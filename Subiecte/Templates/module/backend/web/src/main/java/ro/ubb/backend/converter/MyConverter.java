package ro.ubb.backend.converter;

import org.springframework.stereotype.Component;
import ro.ubb.backend.dto.MyDto;
import ro.ubb.backend.model.MyClass;

@Component
public class MyConverter implements Converter<MyClass, MyDto> {
    @Override
    public MyClass toModel(MyDto myDto) {
        MyClass myClass = new MyClass();
        myClass.setId(myDto.getId());
        myClass.setName(myClass.getName());
        return myClass;
    }

    @Override
    public MyDto toDTO(MyClass myClass) {
        MyDto myDto = new MyDto();
        myDto.setId(myClass.getId());
        myDto.setName(myClass.getName());
        return myDto;
    }
}
