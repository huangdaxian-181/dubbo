package domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 分类
 *
 * @author 搬砖的码农
 * @date 2022 /05/22
 * @email
 */
public class ShopClassDomain implements Serializable {
    private int class_id;

    private String name;

    private String img;

    private int sort;

    private Date create_time;

    private Date update_time;


    /**
     * Sets create time.
     *
     * @param create_time the create time
     */
    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
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
     * Sets sort.
     *
     * @param sort the sort
     */
    public void setSort(int sort) {
        this.sort = sort;
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
     * Gets update time.
     *
     * @return the update time
     */
    public Date getUpdate_time() {
        return update_time;
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
     * Sets img.
     *
     * @param img the img
     */
    public void setImg(String img) {
        this.img = img;
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
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "ShopClassDomain{" +
                "class_id=" + class_id +
                ", name='" + name + '\'' +
                ", img='" + img + '\'' +
                ", sort=" + sort +
                ", create_time=" + create_time +
                ", update_time=" + update_time +
                '}';
    }
}
