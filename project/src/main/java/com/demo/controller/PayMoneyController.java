package com.demo.controller;

import java.io.IOException;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.utils.PaymentUtil;

@Controller
public class PayMoneyController {

	public PayMoneyController() {
	}

	@RequestMapping("/toPayMoneyView")
	public void toPayMoney(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 2、在线支付
		/*
		 * if(pd_FrpId.equals("ABC-NET-B2C")){ //介入农行的接口 }else
		 * if(pd_FrpId.equals("ICBC-NET-B2C")){ //接入工行的接口 }
		 */
		// .......

		// 只接入一个接口，这个接口已经集成所有的银行接口了 ，这个接口是第三方支付平台提供的
		// 接入的是易宝支付
		// 获得 支付必须基本数据
		String orderid = request.getParameter("orderCode");
		// String money = order.getTotal()+"";//支付金额
		String money = "0.01";// 支付金额
		// 银行
		String pd_FrpId = request.getParameter("pd_FrpId");// 各种银行的支付通道
        System.out.println(orderid+"---------"+pd_FrpId);
		// 发给支付公司需要哪些数据
		String p0_Cmd = "Buy"; // 业务类型，固定值是'Buy'
		String p1_MerId = ResourceBundle.getBundle("merchantInfo").getString("p1_MerId");// 商户编号
		String p2_Order = orderid;  //商户订单号
		String p3_Amt = money; ///支付金额
		String p4_Cur = "CNY"; //交易币种，固定值是'CNY' 人民币
		String p5_Pid = ""; //商品名称
		String p6_Pcat = ""; //商品种类
		String p7_Pdesc = ""; //商品描述
		// 支付成功回调地址 ---- 第三方支付公司会访问、用户访问
		// 第三方支付可以访问网址
		String p8_Url = ResourceBundle.getBundle("merchantInfo").getString("callback"); //回调地址
		String p9_SAF = ""; //送货地址
		String pa_MP = ""; //商品扩展信息
		String pr_NeedResponse = "1"; //应答机制
		// 加密hmac 需要密钥
		String keyValue = ResourceBundle.getBundle("merchantInfo").getString("keyValue"); //商户密钥
		String hmac = PaymentUtil.buildHmac(p0_Cmd, p1_MerId, p2_Order, p3_Amt, p4_Cur, p5_Pid, p6_Pcat, p7_Pdesc,
				p8_Url, p9_SAF, pa_MP, pd_FrpId, pr_NeedResponse, keyValue); //mac签名用于验证

		String url = "https://www.yeepay.com/app-merchant-proxy/node?pd_FrpId=" + pd_FrpId + "&p0_Cmd=" + p0_Cmd
				+ "&p1_MerId=" + p1_MerId + "&p2_Order=" + p2_Order + "&p3_Amt=" + p3_Amt + "&p4_Cur=" + p4_Cur
				+ "&p5_Pid=" + p5_Pid + "&p6_Pcat=" + p6_Pcat + "&p7_Pdesc=" + p7_Pdesc + "&p8_Url=" + p8_Url
				+ "&p9_SAF=" + p9_SAF + "&pa_MP=" + pa_MP + "&pr_NeedResponse=" + pr_NeedResponse + "&hmac=" + hmac;

		// 重定向到第三方支付平台
		 response.sendRedirect(url);

		//return "redirect:url";
	}

}
