package com.aloe.pojo.vo.demo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

import java.util.Date;

/**
 * @author lwp
 */
public class SalesLeadsImportInfo extends BaseRowModel {

    /**
     * 导入数据状态【0：失败；1:成功】
     */

    private Integer status;
    /**
     *
     */
    @ExcelProperty(index = 1)
    private String storeCode;

    /**
     * 门店信息
     */
    private String storeName;

    /**
     * 导入数据批次号
     */
    private String importBatchNo;

    /**
     * 线索创建时间
     */
    @ExcelProperty(index = 0, format = "yyyy/mm/dd")
    private Date leadCreateTime;


    /**
     * 姓名
     */
    @ExcelProperty(index = 2)
    private String customName;

    /**
     * 手机号码
     */
    @ExcelProperty(index = 3)
    private String mobilePhone;

    /**
     * 客户性别
     */
    @ExcelProperty(index = 4)
    private String customGender;

    /**
     * 首次渠道
     */
    @ExcelProperty(index = 5)
    private String channelName;

    /**
     * 来源分类
     */
    @ExcelProperty(index = 6)
    private String sourceName;

    /**
     * 来源明细
     */
    @ExcelProperty(index = 7)
    private String sourceDetailName;

    /**
     * 市场活动编码
     */
    @ExcelProperty(index = 8)
    private String marketCode;

    /**
     * 现有车辆
     */
    @ExcelProperty(index = 9)
    private String hadCar;

    /**
     * 备注
     */
    private String remark;

    /**
     * 拥车月数
     */
    @ExcelProperty(index = 10)
    private String hadCarMonth;

    /**
     * 意向车品牌
     */
    @ExcelProperty(index = 11)
    private String carBrand;

    /**
     * 意向车系
     */
    @ExcelProperty(index = 12)
    private String carSeries;

    /**
     * 意向车型
     */
    @ExcelProperty(index = 13)
    private String carModel;

    /**
     * 意向车款
     */
    @ExcelProperty(index = 14)
    private String displayName;

    /**
     * 意向级别名
     */
    @ExcelProperty(index = 15)
    private String intentionLevelName;

    /**
     * 预计购车时间
     */
    @ExcelProperty(index = 16)
    private String estimatedBuyCarTime;

    /**
     * 是否需要试驾
     */
    @ExcelProperty(index = 17)
    private String tryDriveFlag;

    /**
     * 是否需要金融
     */
    @ExcelProperty(index = 18)
    private String financeFlag;

    /**
     * 是否有二手车
     */
    @ExcelProperty(index = 19)
    private String usedCarFlag;

    /**
     * 下次跟进时间
     */
    @ExcelProperty(index = 20)
    private String estimatedNextFollowTime;

    /**
     * 预约到店时间
     */
    @ExcelProperty(index = 21)
    private String appointmentTime;

    /**
     * 所属DCC
     */
    @ExcelProperty(index = 22)
    private String dccName;

    /**
     * 所属销售顾问
     */
    @ExcelProperty(index = 23)
    private String scName;

    /**
     * 获取导入数据状态【0：失败；1:成功】
     *
     * @return status - 导入数据状态【0：失败；1:成功】
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置导入数据状态【0：失败；1:成功】
     *
     * @param status 导入数据状态【0：失败；1:成功】
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * @return storeCode
     */
    public String getStoreCode() {
        return storeCode;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * @param storecode
     */
    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode == null ? null : storeCode.trim();
    }


    /**
     * 设置门店信息
     *
     * @param storename 门店信息
     */
    public void setStoreName(String storeName) {
        this.storeName = storeName == null ? null : storeName.trim();
    }

    /**
     * 获取导入数据批次号
     *
     * @return import_batch_no - 导入数据批次号
     */
    public String getImportBatchNo() {
        return importBatchNo;
    }

    /**
     * 设置导入数据批次号
     *
     * @param importBatchNo 导入数据批次号
     */
    public void setImportBatchNo(String importBatchNo) {
        this.importBatchNo = importBatchNo == null ? null : importBatchNo.trim();
    }

    /**
     * 获取线索创建时间
     *
     * @return lead_create_time - 线索创建时间
     */
    public Date getLeadCreateTime() {
        return leadCreateTime;
    }

    /**
     * 设置线索创建时间
     *
     * @param leadCreateTime 线索创建时间
     */
    public void setLeadCreateTime(Date leadCreateTime) {
        this.leadCreateTime = leadCreateTime;
    }

    /**
     * 获取归属门店
     *
     * @return store_name - 归属门店
     */
    public String getStoreName() {
        return storeName;
    }

    /**
     * 获取姓名
     *
     * @return custom_name - 姓名
     */
    public String getCustomName() {
        return customName;
    }

    /**
     * 设置姓名
     *
     * @param customName 姓名
     */
    public void setCustomName(String customName) {
        this.customName = customName == null ? null : customName.trim();
    }

    /**
     * 获取手机号码
     *
     * @return mobile_phone - 手机号码
     */
    public String getMobilePhone() {
        return mobilePhone;
    }

    /**
     * 设置手机号码
     *
     * @param mobilePhone 手机号码
     */
    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone == null ? null : mobilePhone.trim();
    }

    /**
     * 获取客户性别
     *
     * @return custom_gender - 客户性别
     */
    public String getCustomGender() {
        return customGender;
    }

    /**
     * 设置客户性别
     *
     * @param customGender 客户性别
     */
    public void setCustomGender(String customGender) {
        this.customGender = customGender == null ? null : customGender.trim();
    }

    /**
     * 获取首次渠道
     *
     * @return channel_name - 首次渠道
     */
    public String getChannelName() {
        return channelName;
    }

    /**
     * 设置首次渠道
     *
     * @param channelName 首次渠道
     */
    public void setChannelName(String channelName) {
        this.channelName = channelName == null ? null : channelName.trim();
    }

    /**
     * 获取来源分类
     *
     * @return source_name - 来源分类
     */
    public String getSourceName() {
        return sourceName;
    }

    /**
     * 设置来源分类
     *
     * @param sourceName 来源分类
     */
    public void setSourceName(String sourceName) {
        this.sourceName = sourceName == null ? null : sourceName.trim();
    }

    /**
     * 获取来源明细
     *
     * @return source_detail_name - 来源明细
     */
    public String getSourceDetailName() {
        return sourceDetailName;
    }

    /**
     * 设置来源明细
     *
     * @param sourceDetailName 来源明细
     */
    public void setSourceDetailName(String sourceDetailName) {
        this.sourceDetailName = sourceDetailName == null ? null : sourceDetailName.trim();
    }

    /**
     * 获取市场活动编码
     *
     * @return market_code - 市场活动编码
     */
    public String getMarketCode() {
        return marketCode;
    }

    /**
     * 设置市场活动编码
     *
     * @param marketCode 市场活动编码
     */
    public void setMarketCode(String marketCode) {
        this.marketCode = marketCode == null ? null : marketCode.trim();
    }

    /**
     * 获取现有车辆
     *
     * @return had_car - 现有车辆
     */
    public String getHadCar() {
        return hadCar;
    }

    /**
     * 设置现有车辆
     *
     * @param hadCar 现有车辆
     */
    public void setHadCar(String hadCar) {
        this.hadCar = hadCar == null ? null : hadCar.trim();
    }

    /**
     * 获取拥车月数
     *
     * @return had_car_month - 拥车月数
     */
    public String getHadCarMonth() {
        return hadCarMonth;
    }

    /**
     * 设置拥车月数
     *
     * @param hadCarMonth 拥车月数
     */
    public void setHadCarMonth(String hadCarMonth) {
        this.hadCarMonth = hadCarMonth == null ? null : hadCarMonth.trim();
    }

    /**
     * 获取意向车品牌
     *
     * @return car_brand - 意向车品牌
     */
    public String getCarBrand() {
        return carBrand;
    }

    /**
     * 设置意向车品牌
     *
     * @param carBrand 意向车品牌
     */
    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand == null ? null : carBrand.trim();
    }

    /**
     * 获取意向车系
     *
     * @return car_series - 意向车系
     */
    public String getCarSeries() {
        return carSeries;
    }

    /**
     * 设置意向车系
     *
     * @param carSeries 意向车系
     */
    public void setCarSeries(String carSeries) {
        this.carSeries = carSeries == null ? null : carSeries.trim();
    }

    /**
     * 获取意向车型
     *
     * @return car_model - 意向车型
     */
    public String getCarModel() {
        return carModel;
    }

    /**
     * 设置意向车型
     *
     * @param carModel 意向车型
     */
    public void setCarModel(String carModel) {
        this.carModel = carModel == null ? null : carModel.trim();
    }

    /**
     * 获取意向车款
     *
     * @return display_name - 意向车款
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * 设置意向车款
     *
     * @param displayName 意向车款
     */
    public void setDisplayName(String displayName) {
        this.displayName = displayName == null ? null : displayName.trim();
    }

    /**
     * 获取意向级别名
     *
     * @return intention_level_name - 意向级别名
     */
    public String getIntentionLevelName() {
        return intentionLevelName;
    }

    /**
     * 设置意向级别名
     *
     * @param intentionLevelName 意向级别名
     */
    public void setIntentionLevelName(String intentionLevelName) {
        this.intentionLevelName = intentionLevelName == null ? null : intentionLevelName.trim();
    }

    /**
     * 获取预计购车时间
     *
     * @return estimated_buy_car_time - 预计购车时间
     */
    public String getEstimatedBuyCarTime() {
        return estimatedBuyCarTime;
    }

    /**
     * 设置预计购车时间
     *
     * @param estimatedBuyCarTime 预计购车时间
     */
    public void setEstimatedBuyCarTime(String estimatedBuyCarTime) {
        this.estimatedBuyCarTime = estimatedBuyCarTime == null ? null : estimatedBuyCarTime.trim();
    }

    /**
     * 获取是否需要试驾
     *
     * @return try_drive_flag - 是否需要试驾
     */
    public String getTryDriveFlag() {
        return tryDriveFlag;
    }

    /**
     * 设置是否需要试驾
     *
     * @param tryDriveFlag 是否需要试驾
     */
    public void setTryDriveFlag(String tryDriveFlag) {
        this.tryDriveFlag = tryDriveFlag == null ? null : tryDriveFlag.trim();
    }

    /**
     * 获取是否需要金融
     *
     * @return finance_flag - 是否需要金融
     */
    public String getFinanceFlag() {
        return financeFlag;
    }

    /**
     * 设置是否需要金融
     *
     * @param financeFlag 是否需要金融
     */
    public void setFinanceFlag(String financeFlag) {
        this.financeFlag = financeFlag == null ? null : financeFlag.trim();
    }

    /**
     * 获取是否有二手车
     *
     * @return used_car_flag - 是否有二手车
     */
    public String getUsedCarFlag() {
        return usedCarFlag;
    }

    /**
     * 设置是否有二手车
     *
     * @param usedCarFlag 是否有二手车
     */
    public void setUsedCarFlag(String usedCarFlag) {
        this.usedCarFlag = usedCarFlag == null ? null : usedCarFlag.trim();
    }

    /**
     * 获取下次跟进时间
     *
     * @return estimated_next_follow_time - 下次跟进时间
     */
    public String getEstimatedNextFollowTime() {
        return estimatedNextFollowTime;
    }

    /**
     * 设置下次跟进时间
     *
     * @param estimatedNextFollowTime 下次跟进时间
     */
    public void setEstimatedNextFollowTime(String estimatedNextFollowTime) {
        this.estimatedNextFollowTime = estimatedNextFollowTime == null ? null : estimatedNextFollowTime.trim();
    }

    /**
     * 获取预约到店时间
     *
     * @return appointment_time - 预约到店时间
     */
    public String getAppointmentTime() {
        return appointmentTime;
    }

    /**
     * 设置预约到店时间
     *
     * @param appointmentTime 预约到店时间
     */
    public void setAppointmentTime(String appointmentTime) {
        this.appointmentTime = appointmentTime == null ? null : appointmentTime.trim();
    }

    /**
     * 获取所属DCC
     *
     * @return dcc_name - 所属DCC
     */
    public String getDccName() {
        return dccName;
    }

    /**
     * 设置所属DCC
     *
     * @param dccName 所属DCC
     */
    public void setDccName(String dccName) {
        this.dccName = dccName == null ? null : dccName.trim();
    }

    /**
     * 获取所属销售顾问
     *
     * @return sc_name - 所属销售顾问
     */
    public String getScName() {
        return scName;
    }

    /**
     * 设置所属销售顾问
     *
     * @param scName 所属销售顾问
     */
    public void setScName(String scName) {
        this.scName = scName == null ? null : scName.trim();
    }
}