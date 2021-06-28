package ro.ubb.razvan.county.server;

import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;
import ro.ubb.razvan.county.dto.VoteDTO;

import java.util.concurrent.CompletableFuture;

public class HandleVotingUpdate implements Runnable {
    private String name;
    private RestTemplate restTemplate;
    private int lastA = 0;
    private int lastB = 0;
    private int lastC = 0;

    public HandleVotingUpdate(String name, RestTemplate restTemplate) {
        this.name = name;
        this.restTemplate = restTemplate;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(5000);
                int a = Server.aCount;
                int b = Server.bCount;
                int c = Server.cCount;
                if (lastA + lastB + lastC != a + b + c) {
                    lastA = a;
                    lastB = b;
                    lastC = c;

                    VoteDTO dto = VoteDTO.builder().name(name).a(a).b(b).c(c).nr(a + b + c).build();
                    HttpEntity<VoteDTO> entity = new HttpEntity<>(dto);
                    System.out.println(String.format("Want to send %s %d %d %d %d", name, a, b, c, a + b + c));
                    CompletableFuture.runAsync(
                            () -> restTemplate.postForEntity("http://localhost:8080/api/voting", dto, VoteDTO.class)
                    );
                } else {
                    System.out.println("data not changed");
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
