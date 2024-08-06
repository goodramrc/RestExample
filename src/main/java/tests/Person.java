package tests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data//genereaza automat getter, setter, toString, si un constructor cu parametrii
@NoArgsConstructor //genereaza un constructor fara parametrii(contructor default)
@AllArgsConstructor // genereaza un constructor cu toti parametrii(toate variabilele definite in metode)

public class Person {

    private String name;
    private String email;
    private int age;
}
