package fr.tenisu.backend.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerDataDTO{
    private int rank;
    private int points;
    private int weight;
    private int height;
    private int age;
    private List<Integer> last;
}