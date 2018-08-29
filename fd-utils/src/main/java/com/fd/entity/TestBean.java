package com.fd.entity;


import java.io.Serializable;

import java.math.BigDecimal;

import java.sql.Timestamp;

/**
 */
public class TestBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long ciId;

    /**
     * 商业发票号
     */
    private String ciNumber;

    /**
     * 系统流水号
     */
    private String ciSequenceNumber;

    /**
     * 出口组织
     */
    private Long exportOrgId;

    /**
     * 出口组织
     */
    private String exportOrgIdInfo;

    /**
     * 业务员
     */
    private Long salesmanId;

    /**
     * 业务员
     */
    private String salesmanIdInfo;

    /**
     * 制单日期
     */
    private Timestamp piCreatedDate;

    /**
     * 发票日期
     */
    private Timestamp invoiceDate;

    /**
     * 总账日期
     */
    private Timestamp glDate;

    /**
     * 制单人
     */
    private Long billCreatedById;

    /**
     * 制单人
     */
    private String billCreatedByIdInfo;

    /**
     * CUSTOMER_ID
     */
    private Long customerId;

    /**
     * 客户编码
     */
    private String customerCode;

    /**
     * 客户名称
     */
    private String customerName;

    /**
     * 客户简称
     */
    private String customerNameAbbr;

    /**
     * 转口组织
     */
    private Long transitOrgId;

    /**
     * 转口组织
     */
    private String transitOrgIdInfo;

    /**
     * 中信保投保发票编号
     */
    private String citicInsureInvoiceNo;

    /**
     * 中信保原投保发票编号
     */
    private String citicOldInsureInvoiceNo;

    /**
     * 币种
     */
    private String currency;

    /**
     * 币种
     */
    private String currencyInfo;

    /**
     * 汇率
     */
    private BigDecimal exchangeRate;

    /**
     * 汇率美元
     */
    private BigDecimal exchangeRateUsd;

    /**
     * 汇率日期
     */
    private Timestamp exchangeRateDate;

    /**
     * 汇率类型
     */
    private String exchangeRateType;

    /**
     * 汇率类型
     */
    private String exchangeRateTypeInfo;

    /**
     * 信用证号
     */
    private Long lcId;

    /**
     * 信用证号
     */
    private String lcCode;

    /**
     * 未核销金额
     */
    private BigDecimal notAppliedAmount;

    /**
     * 价格条款
     */
    private Long paymentTermId;

    /**
     * 价格条款
     */
    private String paymentTermIdInfo;

    /**
     * 付款方式
     */
    private Long paymentTypeId;

    /**
     * 导ERP状态
     */
    private String importErpStatus;

    /**
     * CREDIT_CI_ID
     */
    private Long creditCiId;

    /**
     * RECEIPT_EXCHANGE_STATUS
     */
    private String receiptExchangeStatus;

    /**
     * 业务组织ID
     */
    private Long salesUnitId;

    /**
     * RECEIPT_EXCHANGE_STATUS_INFO
     */
    private String receiptExchangeStatusInfo;

    /**
     * 生成EA报文
     */
    private String isCreateEa;

    /**
     * 生成EA信息
     */
    private String createEaInfomation;

    /**
     * 生成CA报文
     */
    private String isCreateCa;

    /**
     * 业务组织
     */
    private String salesUnitName;

    /**
     * EA导EMS状态
     */
    private String eaImportEmsStatusInfo;

    /**
     * 导转口ERP状态
     */
    private String importTerpStatus;

    /**
     * 导转口ERP状态
     */
    private String importTerpStatusInfo;

    /**
     * 是否制作交单
     */
    private String isCreateDeliBill;

    /**
     * 是否已调整
     */
    private String isAdjust;

    /**
     * 是否已交单
     */
    private String isDeliveryBill;

    /**
     * 交单状态
     */
    private String deliveryBillStatus;

    /**
     * 货物金额
     */
    private BigDecimal commodityAmount;

    /**
     * TT后金额
     */
    private BigDecimal ttAfterAmount;

    /**
     * 出运申报状态
     */
    private String shipDeclareStatus;

    /**
     * 提交日期
     */
    private Timestamp submitDate;

    /**
     * 回款时点
     */
    private String receivedPaymentCalcTime;

    /**
     * 客户事业部ID
     */
    private Long cusDivId;

    /**
     * 交单日期
     */
    private Timestamp actualDeliveryBillDate;

    /**
     * 发票总金额USD
     */
    private BigDecimal ciTotalAmountUsd;

    /**
     * TT占比
     */
    private BigDecimal ttRate;

    /**
     * 是否直营
     */
    private String isDirectSales;

    /**
     * 区域
     */
    private String areaName;

    /**
     * 调整后的发票总金额
     */
    private BigDecimal ciSumAmount;

    /**
     * 开票类型
     */
    private String makeInvoiceTypeContent;

    /**
     * 交单适用状态
     */
    private String deliverySuitStatus;

    /**
     * 大区
     */
    private String largeAreaName;

    /**
     * 是否收到IC
     */
    private String isIcReceived;

    /**
     * 大船ETD
     */
    private Timestamp vesselEtdDate;

    /**
     * 大船ETA
     */
    private Timestamp vesselEtaDate;

    /**
     * 是否已投保
     */
    private String isInsure;

    /**
     * 是否已跨月
     */
    private String isOverMonth;

    /**
     * 费用金额
     */
    private BigDecimal exesAmount;

    /**
     * 交单状态info
     */
    private String deliveryBillStatusInfo;

    /**
     * 导转口ERP失败原因
     */
    private String importTerpFailureReason;

    /**
     * CA导EMS状态
     */
    private String caImportEmsStatusInfo;

    /**
     * BILL_DATA_ID
     */
    private BigDecimal billDataId;

    /**
     * 生成CA信息
     */
    private String createCaInfomation;

    /**
     * EA导EMS状态
     */
    private String eaImportEmsStatus;

    /**
     * CA导EMS状态
     */
    private String caImportEmsStatus;

    /**
     * 导ERP状态
     */
    private String importErpStatusInfo;

    /**
     * 失败原因
     */
    private String failureReason;

    /**
     * 付款方式
     */
    private String paymentTypeIdInfo;

    /**
     * 核销状态
     */
    private String appliedStatus;

    /**
     * 核销状态
     */
    private String appliedStatusInfo;

    /**
     * 付款天数
     */
    private Long paymentDays;

    /**
     * 发票总金额
     */
    private BigDecimal ciTotalAmount;

    /**
     * 已核销金额
     */
    private BigDecimal appliedAmount;

    /**
     * TT金额
     */
    private BigDecimal ttAmount;

    /**
     * LC金额
     */
    private BigDecimal lcAmount;

    /**
     * 赊销金额
     */
    private BigDecimal oaAmount;

    /**
     * 唛头
     */
    private String marks;

    /**
     * 发票类型
     */
    private String invoiceType;

    /**
     * 发票类型
     */
    private String invoiceTypeInfo;

    /**
     * 状态
     */
    private String status;

    /**
     * 状态
     */
    private String statusInfo;

    /**
     * 开增值税发票
     */
    private String isVatInvoice;

    /**
     * BILL_PLAN_ID
     */
    private Long billPlanId;

    /**
     * 是否贷记
     */
    private String isCredit;

    /**
     * 是否已融资
     */
    private String isFinancing;

    /**
     * 区域ID
     */
    private Long areaId;

    /**
     * 大区ID
     */
    private Long largeAreaId;

    /**
     * 是否已佣金返利
     */
    private String isCommissionRebate;

    /**
     * 代垫可用余额
     */
    private BigDecimal insteadPaidAmountBalance;

    /**
     * UNIT_ID
     */
    private Long unitId;

    /**
     * UNIT_ID_INFO
     */
    private String unitIdInfo;

    /**
     * BUSI_ROLE_ID
     */
    private Long busiRoleId;

    /**
     * VERSION
     */
    private Long version;

    /**
     * CREATED_BY
     */
    private Long createdBy;

    /**
     * CREATION_DATE
     */
    private Timestamp creationDate;

    /**
     * LAST_UPDATED_BY
     */
    private Long lastUpdatedBy;

    /**
     * LAST_UPDATE_DATE
     */
    private Timestamp lastUpdateDate;

    /**
     * 总账日期FROM
     */
    private Timestamp glDateFrom;

    /**
     * 总账日期To
     */
    private Timestamp glDateTo;

    /**
     * 制单日期FROM
     */
    private Timestamp piCreatedDateFrom;

    /**
     * 制单日期To
     */
    private Timestamp piCreatedDateTo;

    /**
     * 发票日期FROM
     */
    private Timestamp invoiceDateFrom;

    /**
     * 发票日期To
     */
    private Timestamp invoiceDateTo;

    /**
     * 导ERP总账日期FROM
     */
    private Timestamp detailGlDateFrom;

    /**
     * 导ERP总账日期To
     */
    private Timestamp detailGlDateTo;

    /**
     * 总账日期检验失败
     */
    private String detailGlDateCheck;

    /**
     * 产品大类
     */
    private String productDivision;

    /**
     * 产品大类ID
     */
    private Long productCategoryId;

    /**
     * 订舱单号
     */
    private String bookingOrderNumber;

    /**
     * 货柜号
     */
    private String containerNumber;

    /**
     * 出货通知书号
     */
    private String deliveryOrderNumber;

    /**
     * 发票号前缀
     */
    private String ciNumberPrefix;

    /**
     * 发票号后缀
     */
    private String ciNumberSuffix;

    /**
     * 发票金额类型
     */
    private String amountType;

    /**
     * 行类型
     */
    private String lineType;

    /**
     * 行导入ERP状态
     */
    private String processStatus;

    public void setCiId(Long ciId) {
        this.ciId = ciId;
    }

    public Long getCiId() {
        return ciId;
    }

    public void setCiNumber(String ciNumber) {
        this.ciNumber = ciNumber;
    }

    public String getCiNumber() {
        return ciNumber;
    }

    public void setCiSequenceNumber(String ciSequenceNumber) {
        this.ciSequenceNumber = ciSequenceNumber;
    }

    public String getCiSequenceNumber() {
        return ciSequenceNumber;
    }

    public void setExportOrgId(Long exportOrgId) {
        this.exportOrgId = exportOrgId;
    }

    public Long getExportOrgId() {
        return exportOrgId;
    }

    public void setExportOrgIdInfo(String exportOrgIdInfo) {
        this.exportOrgIdInfo = exportOrgIdInfo;
    }

    public String getExportOrgIdInfo() {
        return exportOrgIdInfo;
    }

    public void setSalesmanId(Long salesmanId) {
        this.salesmanId = salesmanId;
    }

    public Long getSalesmanId() {
        return salesmanId;
    }

    public void setSalesmanIdInfo(String salesmanIdInfo) {
        this.salesmanIdInfo = salesmanIdInfo;
    }

    public String getSalesmanIdInfo() {
        return salesmanIdInfo;
    }

    public void setPiCreatedDate(Timestamp piCreatedDate) {
        this.piCreatedDate = piCreatedDate;
    }

    public Timestamp getPiCreatedDate() {
        return piCreatedDate;
    }

    public void setInvoiceDate(Timestamp invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public Timestamp getInvoiceDate() {
        return invoiceDate;
    }

    public void setGlDate(Timestamp glDate) {
        this.glDate = glDate;
    }

    public Timestamp getGlDate() {
        return glDate;
    }

    public void setBillCreatedById(Long billCreatedById) {
        this.billCreatedById = billCreatedById;
    }

    public Long getBillCreatedById() {
        return billCreatedById;
    }

    public void setBillCreatedByIdInfo(String billCreatedByIdInfo) {
        this.billCreatedByIdInfo = billCreatedByIdInfo;
    }

    public String getBillCreatedByIdInfo() {
        return billCreatedByIdInfo;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerNameAbbr(String customerNameAbbr) {
        this.customerNameAbbr = customerNameAbbr;
    }

    public String getCustomerNameAbbr() {
        return customerNameAbbr;
    }

    public void setTransitOrgId(Long transitOrgId) {
        this.transitOrgId = transitOrgId;
    }

    public Long getTransitOrgId() {
        return transitOrgId;
    }

    public void setTransitOrgIdInfo(String transitOrgIdInfo) {
        this.transitOrgIdInfo = transitOrgIdInfo;
    }

    public String getTransitOrgIdInfo() {
        return transitOrgIdInfo;
    }

    public void setCiticInsureInvoiceNo(String citicInsureInvoiceNo) {
        this.citicInsureInvoiceNo = citicInsureInvoiceNo;
    }

    public String getCiticInsureInvoiceNo() {
        return citicInsureInvoiceNo;
    }

    public void setCiticOldInsureInvoiceNo(String citicOldInsureInvoiceNo) {
        this.citicOldInsureInvoiceNo = citicOldInsureInvoiceNo;
    }

    public String getCiticOldInsureInvoiceNo() {
        return citicOldInsureInvoiceNo;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrencyInfo(String currencyInfo) {
        this.currencyInfo = currencyInfo;
    }

    public String getCurrencyInfo() {
        return currencyInfo;
    }

    public void setExchangeRate(BigDecimal exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public BigDecimal getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRateUsd(BigDecimal exchangeRateUsd) {
        this.exchangeRateUsd = exchangeRateUsd;
    }

    public BigDecimal getExchangeRateUsd() {
        return exchangeRateUsd;
    }

    public void setExchangeRateDate(Timestamp exchangeRateDate) {
        this.exchangeRateDate = exchangeRateDate;
    }

    public Timestamp getExchangeRateDate() {
        return exchangeRateDate;
    }

    public void setExchangeRateType(String exchangeRateType) {
        this.exchangeRateType = exchangeRateType;
    }

    public String getExchangeRateType() {
        return exchangeRateType;
    }

    public void setExchangeRateTypeInfo(String exchangeRateTypeInfo) {
        this.exchangeRateTypeInfo = exchangeRateTypeInfo;
    }

    public String getExchangeRateTypeInfo() {
        return exchangeRateTypeInfo;
    }

    public void setLcId(Long lcId) {
        this.lcId = lcId;
    }

    public Long getLcId() {
        return lcId;
    }

    public void setLcCode(String lcCode) {
        this.lcCode = lcCode;
    }

    public String getLcCode() {
        return lcCode;
    }

    public void setNotAppliedAmount(BigDecimal notAppliedAmount) {
        this.notAppliedAmount = notAppliedAmount;
    }

    public BigDecimal getNotAppliedAmount() {
        return notAppliedAmount;
    }

    public void setPaymentTermId(Long paymentTermId) {
        this.paymentTermId = paymentTermId;
    }

    public Long getPaymentTermId() {
        return paymentTermId;
    }

    public void setPaymentTermIdInfo(String paymentTermIdInfo) {
        this.paymentTermIdInfo = paymentTermIdInfo;
    }

    public String getPaymentTermIdInfo() {
        return paymentTermIdInfo;
    }

    public void setPaymentTypeId(Long paymentTypeId) {
        this.paymentTypeId = paymentTypeId;
    }

    public Long getPaymentTypeId() {
        return paymentTypeId;
    }

    public void setImportErpStatus(String importErpStatus) {
        this.importErpStatus = importErpStatus;
    }

    public String getImportErpStatus() {
        return importErpStatus;
    }

    public void setCreditCiId(Long creditCiId) {
        this.creditCiId = creditCiId;
    }

    public Long getCreditCiId() {
        return creditCiId;
    }

    public void setReceiptExchangeStatus(String receiptExchangeStatus) {
        this.receiptExchangeStatus = receiptExchangeStatus;
    }

    public String getReceiptExchangeStatus() {
        return receiptExchangeStatus;
    }

    public void setSalesUnitId(Long salesUnitId) {
        this.salesUnitId = salesUnitId;
    }

    public Long getSalesUnitId() {
        return salesUnitId;
    }

    public void setReceiptExchangeStatusInfo(String receiptExchangeStatusInfo) {
        this.receiptExchangeStatusInfo = receiptExchangeStatusInfo;
    }

    public String getReceiptExchangeStatusInfo() {
        return receiptExchangeStatusInfo;
    }

    public void setIsCreateEa(String isCreateEa) {
        this.isCreateEa = isCreateEa;
    }

    public String getIsCreateEa() {
        return isCreateEa;
    }

    public void setCreateEaInfomation(String createEaInfomation) {
        this.createEaInfomation = createEaInfomation;
    }

    public String getCreateEaInfomation() {
        return createEaInfomation;
    }

    public void setIsCreateCa(String isCreateCa) {
        this.isCreateCa = isCreateCa;
    }

    public String getIsCreateCa() {
        return isCreateCa;
    }

    public void setSalesUnitName(String salesUnitName) {
        this.salesUnitName = salesUnitName;
    }

    public String getSalesUnitName() {
        return salesUnitName;
    }

    public void setEaImportEmsStatusInfo(String eaImportEmsStatusInfo) {
        this.eaImportEmsStatusInfo = eaImportEmsStatusInfo;
    }

    public String getEaImportEmsStatusInfo() {
        return eaImportEmsStatusInfo;
    }

    public void setImportTerpStatus(String importTerpStatus) {
        this.importTerpStatus = importTerpStatus;
    }

    public String getImportTerpStatus() {
        return importTerpStatus;
    }

    public void setImportTerpStatusInfo(String importTerpStatusInfo) {
        this.importTerpStatusInfo = importTerpStatusInfo;
    }

    public String getImportTerpStatusInfo() {
        return importTerpStatusInfo;
    }

    public void setIsCreateDeliBill(String isCreateDeliBill) {
        this.isCreateDeliBill = isCreateDeliBill;
    }

    public String getIsCreateDeliBill() {
        return isCreateDeliBill;
    }

    public void setIsAdjust(String isAdjust) {
        this.isAdjust = isAdjust;
    }

    public String getIsAdjust() {
        return isAdjust;
    }

    public void setIsDeliveryBill(String isDeliveryBill) {
        this.isDeliveryBill = isDeliveryBill;
    }

    public String getIsDeliveryBill() {
        return isDeliveryBill;
    }

    public void setDeliveryBillStatus(String deliveryBillStatus) {
        this.deliveryBillStatus = deliveryBillStatus;
    }

    public String getDeliveryBillStatus() {
        return deliveryBillStatus;
    }

    public void setCommodityAmount(BigDecimal commodityAmount) {
        this.commodityAmount = commodityAmount;
    }

    public BigDecimal getCommodityAmount() {
        return commodityAmount;
    }

    public void setTtAfterAmount(BigDecimal ttAfterAmount) {
        this.ttAfterAmount = ttAfterAmount;
    }

    public BigDecimal getTtAfterAmount() {
        return ttAfterAmount;
    }

    public void setShipDeclareStatus(String shipDeclareStatus) {
        this.shipDeclareStatus = shipDeclareStatus;
    }

    public String getShipDeclareStatus() {
        return shipDeclareStatus;
    }

    public void setSubmitDate(Timestamp submitDate) {
        this.submitDate = submitDate;
    }

    public Timestamp getSubmitDate() {
        return submitDate;
    }

    public void setReceivedPaymentCalcTime(String receivedPaymentCalcTime) {
        this.receivedPaymentCalcTime = receivedPaymentCalcTime;
    }

    public String getReceivedPaymentCalcTime() {
        return receivedPaymentCalcTime;
    }

    public void setCusDivId(Long cusDivId) {
        this.cusDivId = cusDivId;
    }

    public Long getCusDivId() {
        return cusDivId;
    }

    public void setActualDeliveryBillDate(Timestamp actualDeliveryBillDate) {
        this.actualDeliveryBillDate = actualDeliveryBillDate;
    }

    public Timestamp getActualDeliveryBillDate() {
        return actualDeliveryBillDate;
    }

    public void setCiTotalAmountUsd(BigDecimal ciTotalAmountUsd) {
        this.ciTotalAmountUsd = ciTotalAmountUsd;
    }

    public BigDecimal getCiTotalAmountUsd() {
        return ciTotalAmountUsd;
    }

    public void setTtRate(BigDecimal ttRate) {
        this.ttRate = ttRate;
    }

    public BigDecimal getTtRate() {
        return ttRate;
    }

    public void setIsDirectSales(String isDirectSales) {
        this.isDirectSales = isDirectSales;
    }

    public String getIsDirectSales() {
        return isDirectSales;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setCiSumAmount(BigDecimal ciSumAmount) {
        this.ciSumAmount = ciSumAmount;
    }

    public BigDecimal getCiSumAmount() {
        return ciSumAmount;
    }

    public void setMakeInvoiceTypeContent(String makeInvoiceTypeContent) {
        this.makeInvoiceTypeContent = makeInvoiceTypeContent;
    }

    public String getMakeInvoiceTypeContent() {
        return makeInvoiceTypeContent;
    }

    public void setDeliverySuitStatus(String deliverySuitStatus) {
        this.deliverySuitStatus = deliverySuitStatus;
    }

    public String getDeliverySuitStatus() {
        return deliverySuitStatus;
    }

    public void setLargeAreaName(String largeAreaName) {
        this.largeAreaName = largeAreaName;
    }

    public String getLargeAreaName() {
        return largeAreaName;
    }

    public void setIsIcReceived(String isIcReceived) {
        this.isIcReceived = isIcReceived;
    }

    public String getIsIcReceived() {
        return isIcReceived;
    }

    public void setVesselEtdDate(Timestamp vesselEtdDate) {
        this.vesselEtdDate = vesselEtdDate;
    }

    public Timestamp getVesselEtdDate() {
        return vesselEtdDate;
    }

    public void setVesselEtaDate(Timestamp vesselEtaDate) {
        this.vesselEtaDate = vesselEtaDate;
    }

    public Timestamp getVesselEtaDate() {
        return vesselEtaDate;
    }

    public void setIsInsure(String isInsure) {
        this.isInsure = isInsure;
    }

    public String getIsInsure() {
        return isInsure;
    }

    public void setIsOverMonth(String isOverMonth) {
        this.isOverMonth = isOverMonth;
    }

    public String getIsOverMonth() {
        return isOverMonth;
    }

    public void setExesAmount(BigDecimal exesAmount) {
        this.exesAmount = exesAmount;
    }

    public BigDecimal getExesAmount() {
        return exesAmount;
    }

    public void setDeliveryBillStatusInfo(String deliveryBillStatusInfo) {
        this.deliveryBillStatusInfo = deliveryBillStatusInfo;
    }

    public String getDeliveryBillStatusInfo() {
        return deliveryBillStatusInfo;
    }

    public void setImportTerpFailureReason(String importTerpFailureReason) {
        this.importTerpFailureReason = importTerpFailureReason;
    }

    public String getImportTerpFailureReason() {
        return importTerpFailureReason;
    }

    public void setCaImportEmsStatusInfo(String caImportEmsStatusInfo) {
        this.caImportEmsStatusInfo = caImportEmsStatusInfo;
    }

    public String getCaImportEmsStatusInfo() {
        return caImportEmsStatusInfo;
    }

    public void setBillDataId(BigDecimal billDataId) {
        this.billDataId = billDataId;
    }

    public BigDecimal getBillDataId() {
        return billDataId;
    }

    public void setCreateCaInfomation(String createCaInfomation) {
        this.createCaInfomation = createCaInfomation;
    }

    public String getCreateCaInfomation() {
        return createCaInfomation;
    }

    public void setEaImportEmsStatus(String eaImportEmsStatus) {
        this.eaImportEmsStatus = eaImportEmsStatus;
    }

    public String getEaImportEmsStatus() {
        return eaImportEmsStatus;
    }

    public void setCaImportEmsStatus(String caImportEmsStatus) {
        this.caImportEmsStatus = caImportEmsStatus;
    }

    public String getCaImportEmsStatus() {
        return caImportEmsStatus;
    }

    public void setImportErpStatusInfo(String importErpStatusInfo) {
        this.importErpStatusInfo = importErpStatusInfo;
    }

    public String getImportErpStatusInfo() {
        return importErpStatusInfo;
    }

    public void setFailureReason(String failureReason) {
        this.failureReason = failureReason;
    }

    public String getFailureReason() {
        return failureReason;
    }

    public void setPaymentTypeIdInfo(String paymentTypeIdInfo) {
        this.paymentTypeIdInfo = paymentTypeIdInfo;
    }

    public String getPaymentTypeIdInfo() {
        return paymentTypeIdInfo;
    }

    public void setAppliedStatus(String appliedStatus) {
        this.appliedStatus = appliedStatus;
    }

    public String getAppliedStatus() {
        return appliedStatus;
    }

    public void setAppliedStatusInfo(String appliedStatusInfo) {
        this.appliedStatusInfo = appliedStatusInfo;
    }

    public String getAppliedStatusInfo() {
        return appliedStatusInfo;
    }

    public void setPaymentDays(Long paymentDays) {
        this.paymentDays = paymentDays;
    }

    public Long getPaymentDays() {
        return paymentDays;
    }

    public void setCiTotalAmount(BigDecimal ciTotalAmount) {
        this.ciTotalAmount = ciTotalAmount;
    }

    public BigDecimal getCiTotalAmount() {
        return ciTotalAmount;
    }

    public void setAppliedAmount(BigDecimal appliedAmount) {
        this.appliedAmount = appliedAmount;
    }

    public BigDecimal getAppliedAmount() {
        return appliedAmount;
    }

    public void setTtAmount(BigDecimal ttAmount) {
        this.ttAmount = ttAmount;
    }

    public BigDecimal getTtAmount() {
        return ttAmount;
    }

    public void setLcAmount(BigDecimal lcAmount) {
        this.lcAmount = lcAmount;
    }

    public BigDecimal getLcAmount() {
        return lcAmount;
    }

    public void setOaAmount(BigDecimal oaAmount) {
        this.oaAmount = oaAmount;
    }

    public BigDecimal getOaAmount() {
        return oaAmount;
    }

    public void setMarks(String marks) {
        this.marks = marks;
    }

    public String getMarks() {
        return marks;
    }

    public void setInvoiceType(String invoiceType) {
        this.invoiceType = invoiceType;
    }

    public String getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceTypeInfo(String invoiceTypeInfo) {
        this.invoiceTypeInfo = invoiceTypeInfo;
    }

    public String getInvoiceTypeInfo() {
        return invoiceTypeInfo;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatusInfo(String statusInfo) {
        this.statusInfo = statusInfo;
    }

    public String getStatusInfo() {
        return statusInfo;
    }

    public void setIsVatInvoice(String isVatInvoice) {
        this.isVatInvoice = isVatInvoice;
    }

    public String getIsVatInvoice() {
        return isVatInvoice;
    }

    public void setBillPlanId(Long billPlanId) {
        this.billPlanId = billPlanId;
    }

    public Long getBillPlanId() {
        return billPlanId;
    }

    public void setIsCredit(String isCredit) {
        this.isCredit = isCredit;
    }

    public String getIsCredit() {
        return isCredit;
    }

    public void setIsFinancing(String isFinancing) {
        this.isFinancing = isFinancing;
    }

    public String getIsFinancing() {
        return isFinancing;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    public Long getAreaId() {
        return areaId;
    }

    public void setLargeAreaId(Long largeAreaId) {
        this.largeAreaId = largeAreaId;
    }

    public Long getLargeAreaId() {
        return largeAreaId;
    }

    public void setIsCommissionRebate(String isCommissionRebate) {
        this.isCommissionRebate = isCommissionRebate;
    }

    public String getIsCommissionRebate() {
        return isCommissionRebate;
    }

    public void setInsteadPaidAmountBalance(BigDecimal insteadPaidAmountBalance) {
        this.insteadPaidAmountBalance = insteadPaidAmountBalance;
    }

    public BigDecimal getInsteadPaidAmountBalance() {
        return insteadPaidAmountBalance;
    }

    public void setUnitId(Long unitId) {
        this.unitId = unitId;
    }

    public Long getUnitId() {
        return unitId;
    }

    public void setUnitIdInfo(String unitIdInfo) {
        this.unitIdInfo = unitIdInfo;
    }

    public String getUnitIdInfo() {
        return unitIdInfo;
    }

    public void setBusiRoleId(Long busiRoleId) {
        this.busiRoleId = busiRoleId;
    }

    public Long getBusiRoleId() {
        return busiRoleId;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Long getVersion() {
        return version;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setLastUpdatedBy(Long lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public Long getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdateDate(Timestamp lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public Timestamp getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setGlDateFrom(Timestamp glDateFrom) {
        this.glDateFrom = glDateFrom;
    }

    public Timestamp getGlDateFrom() {
        return glDateFrom;
    }

    public void setGlDateTo(Timestamp glDateTo) {
        this.glDateTo = glDateTo;
    }

    public Timestamp getGlDateTo() {
        return glDateTo;
    }

    public void setPiCreatedDateFrom(Timestamp piCreatedDateFrom) {
        this.piCreatedDateFrom = piCreatedDateFrom;
    }

    public Timestamp getPiCreatedDateFrom() {
        return piCreatedDateFrom;
    }

    public void setPiCreatedDateTo(Timestamp piCreatedDateTo) {
        this.piCreatedDateTo = piCreatedDateTo;
    }

    public Timestamp getPiCreatedDateTo() {
        return piCreatedDateTo;
    }

    public void setInvoiceDateFrom(Timestamp invoiceDateFrom) {
        this.invoiceDateFrom = invoiceDateFrom;
    }

    public Timestamp getInvoiceDateFrom() {
        return invoiceDateFrom;
    }

    public void setInvoiceDateTo(Timestamp invoiceDateTo) {
        this.invoiceDateTo = invoiceDateTo;
    }

    public Timestamp getInvoiceDateTo() {
        return invoiceDateTo;
    }

    public void setDetailGlDateFrom(Timestamp detailGlDateFrom) {
        this.detailGlDateFrom = detailGlDateFrom;
    }

    public Timestamp getDetailGlDateFrom() {
        return detailGlDateFrom;
    }

    public void setDetailGlDateTo(Timestamp detailGlDateTo) {
        this.detailGlDateTo = detailGlDateTo;
    }

    public Timestamp getDetailGlDateTo() {
        return detailGlDateTo;
    }

    public void setDetailGlDateCheck(String detailGlDateCheck) {
        this.detailGlDateCheck = detailGlDateCheck;
    }

    public String getDetailGlDateCheck() {
        return detailGlDateCheck;
    }

    public void setProductDivision(String productDivision) {
        this.productDivision = productDivision;
    }

    public String getProductDivision() {
        return productDivision;
    }

    public void setProductCategoryId(Long productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    public Long getProductCategoryId() {
        return productCategoryId;
    }

    public void setBookingOrderNumber(String bookingOrderNumber) {
        this.bookingOrderNumber = bookingOrderNumber;
    }

    public String getBookingOrderNumber() {
        return bookingOrderNumber;
    }

    public void setContainerNumber(String containerNumber) {
        this.containerNumber = containerNumber;
    }

    public String getContainerNumber() {
        return containerNumber;
    }

    public void setDeliveryOrderNumber(String deliveryOrderNumber) {
        this.deliveryOrderNumber = deliveryOrderNumber;
    }

    public String getDeliveryOrderNumber() {
        return deliveryOrderNumber;
    }

    public void setCiNumberPrefix(String ciNumberPrefix) {
        this.ciNumberPrefix = ciNumberPrefix;
    }

    public String getCiNumberPrefix() {
        return ciNumberPrefix;
    }

    public void setCiNumberSuffix(String ciNumberSuffix) {
        this.ciNumberSuffix = ciNumberSuffix;
    }

    public String getCiNumberSuffix() {
        return ciNumberSuffix;
    }

    public void setAmountType(String amountType) {
        this.amountType = amountType;
    }

    public String getAmountType() {
        return amountType;
    }

    public void setLineType(String lineType) {
        this.lineType = lineType;
    }

    public String getLineType() {
        return lineType;
    }

    public void setProcessStatus(String processStatus) {
        this.processStatus = processStatus;
    }

    public String getProcessStatus() {
        return processStatus;
    }
}
