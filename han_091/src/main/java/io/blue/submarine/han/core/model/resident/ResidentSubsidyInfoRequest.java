package io.blue.submarine.han.core.model.resident;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 居民补助信息请求类.
 *
 * @author shucunbin
 * @date 2022-02-06 15:40
 */
@Getter
@Setter
@ToString
public class ResidentSubsidyInfoRequest {
    private String number;
    private InData inData;

    public ResidentSubsidyInfoRequest(String id) {
        this.number = "Q2059";
        this.inData =  new InData(id);
    }

    @Getter
    @Setter
    static class InData {
        private String aac002;
        private String startrow;
        private String endrow;

        public InData(String id) {
            this.startrow = "1";
            this.endrow = "299";
            this.aac002 = id;
        }
    }
}

/*
{"number":"Q2059",
"inData":{"aac002":"513434196203072529","startrow":"1","endrow":"299"}}
 */
