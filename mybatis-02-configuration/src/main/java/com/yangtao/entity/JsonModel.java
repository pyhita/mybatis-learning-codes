package com.yangtao.entity;

import lombok.Data;

/**
 * @Author: kante_yang
 * @Date: 2023/12/14
 */
@Data
public class JsonModel {

    private Integer id;
//    private JSONObject jsonModel;
    private String jsonModel;
    private String testField;
    private Enabled enabled;

    public enum Enabled {
        enabled(1),
        disabled(0);

        private final int value;

        private Enabled(int value) {
            this.value = value;
        }

        public Integer getValue() {
            return this.value;
        }

    }
}
