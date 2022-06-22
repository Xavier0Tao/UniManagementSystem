package org.uni.dto;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class healthCondition {

    //是否去过重点疫区?
    boolean isBeenArea;

    //aboard>
    boolean isBeenAboard;

    //is close
    boolean isClose;

    //是否确诊
    boolean isConfirmed;

    //有一种情况
    boolean isUnhealthy;

    //超过一种情况
    boolean isSeriousUnheathy;

}
