package domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 轮博图数据表
 *
 * @author 搬砖的码农
 * @date 2022 /05/21
 * @email
 */
public class ShopRotationDomain implements Serializable {
    private int rotation_id;

    private String img;

    private int goods_id;

    private int sort;

    private int is_delete;

    private Date create_time;

    private Date update_time;

    private String back;


    public String getBack() {
        return back;
    }

    public void setBack(String back) {
        this.back = back;
    }

    /**
     * Sets goods id.
     *
     * @param goods_id the goods id
     */
    public void setGoods_id(int goods_id) {
        this.goods_id = goods_id;
    }

    /**
     * Gets goods id.
     *
     * @return the goods id
     */
    public int getGoods_id() {
        return goods_id;
    }

    /**
     * Sets rotation id.
     *
     * @param rotation_id the rotation id
     */
    public void setRotation_id(int rotation_id) {
        this.rotation_id = rotation_id;
    }

    /**
     * Gets rotation id.
     *
     * @return the rotation id
     */
    public int getRotation_id() {
        return rotation_id;
    }

    /**
     * Gets is delete.
     *
     * @return the is delete
     */
    public int getIs_delete() {
        return is_delete;
    }

    /**
     * Sets is delete.
     *
     * @param is_delete the is delete
     */
    public void setIs_delete(int is_delete) {
        this.is_delete = is_delete;
    }

    /**
     * Gets img.
     *
     * @return the img
     */
    public String getImg() {
        return img;
    }

    /**
     * Sets img.
     *
     * @param img the img
     */
    public void setImg(String img) {
        this.img = img;
    }

    /**
     * Sets update time.
     *
     * @param update_time the update time
     */
    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    /**
     * Gets update time.
     *
     * @return the update time
     */
    public Date getUpdate_time() {
        return update_time;
    }

    /**
     * Gets sort.
     *
     * @return the sort
     */
    public int getSort() {
        return sort;
    }

    /**
     * Sets sort.
     *
     * @param sort the sort
     */
    public void setSort(int sort) {
        this.sort = sort;
    }

    /**
     * Gets create time.
     *
     * @return the create time
     */
    public Date getCreate_time() {
        return create_time;
    }

    /**
     * Sets create time.
     *
     * @param create_time the create time
     */
    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    @Override
    public String toString() {
        return "ShopRotationMapper{" +
                "rotation_id=" + rotation_id +
                ", img='" + img + '\'' +
                ", goods_id=" + goods_id +
                ", sort=" + sort +
                ", is_delete=" + is_delete +
                ", create_time=" + create_time +
                ", update_time=" + update_time +
                '}';
    }
}
