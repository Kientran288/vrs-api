package com.vsr.spg.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

@EqualsAndHashCode(callSuper = false)
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class VisitorDTO {
}
