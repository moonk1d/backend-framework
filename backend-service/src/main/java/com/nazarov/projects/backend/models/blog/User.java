package com.nazarov.projects.backend.models.blog;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public final class User {

  private long id;
  private String name;
  private String nickName;

}
