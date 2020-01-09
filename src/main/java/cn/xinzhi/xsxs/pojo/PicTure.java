package cn.xinzhi.xsxs.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "图片信息")
public class PicTure {
    @ApiModelProperty(value = "id")
    private Integer id;
    @ApiModelProperty(value = "图片类型")
    private String pi_img;
    @ApiModelProperty(value = "图片路径")
    private String pi_background;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPi_img() {
        return pi_img;
    }

    public void setPi_img(String pi_img) {
        this.pi_img = pi_img;
    }

    public String getPi_background() {
        return pi_background;
    }

    public void setPi_background(String pi_background) {
        this.pi_background = pi_background;
    }
}
