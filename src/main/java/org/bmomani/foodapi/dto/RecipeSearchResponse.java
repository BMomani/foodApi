package org.bmomani.foodapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RecipeSearchResponse {
    public int offset;
    public int number;
    public ArrayList<Recipe> results;
    public int totalResults;
}
