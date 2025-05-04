package com.halfacode.news.dto.response;

import com.halfacode.news.dto.response.enums.ErrorType;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {

  private String code;
  private ErrorType type;
  private String message;
  private List<String> details;
  private String timestamp;

}
