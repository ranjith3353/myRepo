package dto.Y2022;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ElfsDto {

    private List<Integer> calories;

    private int totalCalories;

    public ElfsDto() {
        this.calories = new ArrayList<>();
        this.totalCalories = 0;
    }

    public List<Integer> getCalories() {
        return calories;
    }

    public int getTotalCalories() {
        return totalCalories;
    }

    public void setTotalCalories(int totalCalories) {
        this.totalCalories = totalCalories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ElfsDto elfsDto = (ElfsDto) o;
        return totalCalories == elfsDto.totalCalories && Objects.equals(calories, elfsDto.calories);
    }

    @Override
    public int hashCode() {
        return Objects.hash(calories, totalCalories);
    }

    @Override
    public String toString() {
        return "ElfsDto{" +
                "calories=" + calories +
                ", totalCalories=" + totalCalories +
                '}';
    }


}
