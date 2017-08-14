package com.warehouse.dao;

import com.warehouse.entity.Material;
import com.warehouse.entity.MaterialRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by kone on 2017-08-08.
 */
public interface IMaterialRecordDao {

    /**
     * 查看原材料入库记录
     * @return
     */
    public List<MaterialRecord> viewMaterialRecord(@Param("materialId") Long materialId,
                                                   @Param("startTime")  String startTime,
                                                   @Param("endTime")  String endTime,
                                                   @Param("offset")int offset,
                                                   @Param("size")int size);

    /**
     * 增加原材料入库记录
     * @param materialRecord
     * @return
     */
    public boolean addMaterialRecord(MaterialRecord materialRecord);

    /**
     * 删除原材料
     * @param id
     * @return
     */
    public boolean deleteMaterialRecord(Long id);

    /**
     * 获取指定的时间段的材料总数
     * @param materialId
     * @param startTime
     * @param endTime
     * @return
     */
    public Float getSum(@Param("materialId") Long materialId,@Param("startTime")  String startTime,@Param("endTime")  String endTime);

    /**
     * 获取总记录数
     * @param materialId
     * @return
     */
    public Integer getCount(@Param("materialId") Long materialId, @Param("startTime")  String startTime,@Param("endTime")  String endTime);
}
