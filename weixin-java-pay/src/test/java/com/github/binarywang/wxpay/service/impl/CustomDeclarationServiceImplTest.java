package com.github.binarywang.wxpay.service.impl;

import com.github.binarywang.wxpay.bean.customs.*;
import com.github.binarywang.wxpay.exception.WxPayException;
import com.github.binarywang.wxpay.service.CustomDeclarationService;
import com.github.binarywang.wxpay.service.WxPayService;
import com.github.binarywang.wxpay.testbase.ApiTestModule;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;

@Slf4j
@Test
@Guice(modules = ApiTestModule.class)
public class CustomDeclarationServiceImplTest {
  private static final Gson GSON = new GsonBuilder().create();
  @Inject
  private WxPayService wxPayService;

  @Test
  public void testDeclare() throws WxPayException {
    CustomDeclarationService customDeclarationService = new CustomDeclarationServiceImpl(wxPayService);
    String requestParamStr = "{}";
    /*
     * {"appid":"wxd678efh567hg6787","mchid":"1230000109","out_trade_no":"20150806125346","transaction_id":"1000320306201511078440737890","customs":"SHANGHAI_ZS","merchant_customs_no":"123456","duty":888,"sub_order_no":"20150806125346","fee_type":"CNY","order_fee":888,"transport_fee":888,"product_fee":888}
    */
    requestParamStr = "{\"appid\":\"wx4275b35dac8f1bde\",\"mchid\":\"1623887211\",\"out_trade_no\":\"schiff32205031811186126779176\",\"transaction_id\":\"4200001480202205035540107159\",\"customs\":\"NINGBO\",\"merchant_customs_no\":\"4401230148\"}";
    DeclarationRequest request = GSON.fromJson(requestParamStr, DeclarationRequest.class);

    DeclarationResult result = customDeclarationService.declare(request);
    System.out.println("result = " + result);
  }

  @Test
  public void testQuery() throws WxPayException {
    CustomDeclarationService customDeclarationService = new CustomDeclarationServiceImpl(wxPayService);
    String requestParamStr = "{}";
    /*
     * {"appid":"wxd678efh567hg6787","mchid":"1230000109","order_type":"transaction_id","order_no":"20150806125346","customs":"SHANGHAI_ZS","offset":"0","limit":"20"}
     */
    requestParamStr = "{\"appid\":\"wx4275b35dac8f1bde\",\"mchid\":\"1623887211\",\"order_type\":\"transaction_id\",\"order_no\":\"4200001480202205035540107159\",\"customs\":\"NINGBO\",\"offset\":\"0\",\"limit\":\"20\"}";
    DeclarationQueryRequest request = GSON.fromJson(requestParamStr, DeclarationQueryRequest.class);

    DeclarationQueryResult result = customDeclarationService.query(request);
    System.out.println("result = " + result);
  }

  @Test
  public void testVerifyCertificate() throws WxPayException {
    CustomDeclarationService customDeclarationService = new CustomDeclarationServiceImpl(wxPayService);
    String requestParamStr = "{}";
    /*
     * {"appid":"wxd678efh567hg6787","mchid":"1230000109","out_trade_no":"20150806125346","transaction_id":"1000320306201511078440737890","sub_order_no":"20150806125346","customs":"SHANGHAI_ZS","merchant_customs_no":"123456","certificate_type":"IDCARD","certificate_id":"330821198809085211","certificate_name":"张三"}
     */
    requestParamStr = "{\"appid\":\"wx4275b35dac8f1bde\",\"mchid\":\"1623887211\",\"out_trade_no\":\"schiff32205031811186126779176\",\"transaction_id\":\"4200001480202205035540107159\",\"customs\":\"NINGBO\",\"merchant_customs_no\":\"4401230148\",\"certificate_type\":\"IDCARD\",\"certificate_id\":\"430223199101264838\",\"certificate_name\":\"易株强\"}";
    VerifyCertificateRequest request = GSON.fromJson(requestParamStr, VerifyCertificateRequest.class);

    VerifyCertificateResult result = customDeclarationService.verifyCertificate(request);
    System.out.println("result = " + result);
  }

  @Test
  public void testModify() throws WxPayException {
    CustomDeclarationService customDeclarationService = new CustomDeclarationServiceImpl(wxPayService);
    String requestParamStr = "{}";
    /*
     * {"appid":"wxd678efh567hg6787","mchid":"1230000109","out_trade_no":"20150806125346","transaction_id":"1000320306201511078440737890","customs":"SHANGHAI_ZS","merchant_customs_no":"123456","duty":888,"sub_order_no":"20150806125346","fee_type":"CNY","order_fee":888,"transport_fee":888,"product_fee":888}
     */
    requestParamStr = "{\"appid\":\"wx4275b35dac8f1bde\",\"mchid\":\"1623887211\",\"out_trade_no\":\"schiff32205031811186126779176\",\"transaction_id\":\"4200001480202205035540107159\",\"customs\":\"NINGBO\",\"merchant_customs_no\":\"4401230148\"}";

    DeclarationRequest request = GSON.fromJson(requestParamStr, DeclarationRequest.class);

    DeclarationResult result = customDeclarationService.modify(request);
    System.out.println("result = " + result);
  }

  @Test
  public void testRedeclare() throws WxPayException {
    CustomDeclarationService customDeclarationService = new CustomDeclarationServiceImpl(wxPayService);
    String requestParamStr = "{}";
    /*
     * {"appid":"wxd678efh567hg6787","mchid":"1230000109","out_trade_no":"20150806125346","transaction_id":"1000320306201511078440737890","sub_order_no":"20150806125346","sub_order_id":"1000320306201511078440737891","customs":"SHANGHAI_ZS","merchant_customs_no":"123456"}
     */
    requestParamStr = "{\"appid\":\"wx4275b35dac8f1bde\",\"mchid\":\"1623887211\",\"out_trade_no\":\"schiff32205031811186126779176\",\"transaction_id\":\"4200001480202205035540107159\",\"customs\":\"NINGBO\",\"merchant_customs_no\":\"4401230148\"}";
    RedeclareRequest request = GSON.fromJson(requestParamStr, RedeclareRequest.class);

    RedeclareResult result = customDeclarationService.redeclare(request);
    System.out.println("result = " + result);
  }
}
