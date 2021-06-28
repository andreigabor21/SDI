package ro.ubb.gunshop.dto;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class BaseDTO<ID extends Serializable> implements Serializable {
    public ID id;
}
