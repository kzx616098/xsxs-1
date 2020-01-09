package cn.xinzhi.xsxs.service;

public interface IRedisService {
    /*
     * 存储数据
     */
    void set(String key, String value);
    /*
    * 获取数据
     */
    String get(String key);
    /*
    * 设置超期时间
     */
    boolean expire(String key, long expire);
    /*
    * 删除数据
     */
    void remove(String key);

    /**
     *  自增操作
     * @param key
     * @param delta 自增步长
     * @return
     */
    Long increment(String key, long delta);
}
