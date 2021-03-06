package V_Can;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import Tools.BaseClass;
import Tools.PageManager;
import Tools.PageNavigation;
import V_Can.V_Can;
import java.util.concurrent.TimeUnit;

import org.apache.commons.codec.digest.Crypt;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.server.handler.SendKeys;
import org.testng.Assert;

import android.app.PendingIntent.CanceledException;
import android.inputmethodservice.Keyboard;

public class test extends BaseClass{
	
	private static V_Can vcan;
	protected static PageManager pageManager;
	
	public static void main(String[] args) throws InterruptedException, IOException {
		
		String deviceName = "VCan";
		String platformVersion = "4.4.2";
		String apkName = "SmartCommunity_Signed_v1.2.287.apk";
		String appActivity = "com.sht.smartcommunity.ui.activity.StartActivity";
		String AppiumServerIP = "http://127.0.0.1:4723/wd/hub";
		
		AndroidDriver driver;
		
		File apk = new File(System.getProperty("user.dir")+File.separator+"apps"+File.separator+apkName);
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", deviceName);
		capabilities.setCapability("platformVersion", platformVersion);
		capabilities.setCapability("app", apk);
		capabilities.setCapability("appActivity", appActivity);
		capabilities.setCapability("noSign", true);
		capabilities.setCapability("noReset", true);
		capabilities.setCapability("unicodeKeyboard", true);
		capabilities.setCapability("resetKeyboard", true);
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
		
		vcan = new V_Can(driver);
		pageManager = new PageManager(vcan);
		  
		Thread.sleep(600);
		
		while(true){

		//登录入口
		pageManager.getPageMyInfo().LoginPage();

		//注册
//		pageManager.getPageRegister().DoRegister();
		
		//登录操作
		pageManager.getPageLogin().LoginAction();
		pageManager.getPageMyInfo().BackHomeView();
		
		
		/*
		//修改当前用户信息
		pageManager.getPageMyInfo().LoginPage();
		pageManager.getPageLogin().editMyInfo();
		pageManager.getPageMyInfo().BackHomeView();
		
		//**侧边栏** 
		pageManager.getPageMyInfo().getLoginImageView();
		
		//侧边栏各进入一次并退出
		pageManager.getPageMyInfo().gotoNewCityCard();
		pageManager.getPageMyInfo().gotoMyCard();
		pageManager.getPageMyInfo().gotoPayPassword(); 
		pageManager.getPageMyInfo().gotoMyOrder(); //保险捕捉不到
		pageManager.getPageMyInfo().gotoMyCoupons(); //因为没优惠券，未做查看详情
		pageManager.getPageMyInfo().gotoMemberPoints();
		pageManager.getPageMyInfo().gotoCall();
		pageManager.getPageMyInfo().gotoUpdate();
		pageManager.getPageMyInfo().gotoAbout(); 
		
		pageManager.getPageMyInfo().BackHomeView();	
		*/	
		
		
		
		//选择城市
//		pageManager.getPageHome().gotoSelectCity("北京市");     //还未修改完成
		
		
		
//		pageManager.getPageNavigation().goToHappyTab();
//		pageManager.getPageHappyLife().visitHappyLife();
		
		pageManager.getPageNavigation().goToExploreTab();
		pageManager.getPageExplore().clickFoodItem(0);
		
		//个人中心入口 -> 注销
		if(vcan.iSLogin.equals("Yes")){
			pageManager.getPageNavigation().goToHomeTab();
			pageManager.getPageMyInfo().LoginPage();
			pageManager.getPageMyInfo().LogOutAction();
			vcan.iSLogin = "No";
		}
		else{
			//进入个人中心	
		}
			
		}
		
		/*
//		pageManager.getPageNavigation().goToExploreTab();
//		pageManager.getPageNavigation().goToHomeTab();
		
//		driver.findElement(By.id("edtTxt_pwd")).sendKeys(Crypt.crypt("******"));
//		driver.findElement(By.id("edtTxt_pwd")).getText().SetSecure();
		
		//通过xpath定位未成功
//		driver.findElement(By.xpath("//className[contains(@text,'忘记')]")).click();
		
		//通过文本定位
//		vcan.clickByText("忘记密码?");

		Thread.sleep(500);
		//通过类定位
//		((WebElement) driver.findElements(By.className("android.widget.LinearLayout")).get(4)).click();
	
		//通过ID拿控件，输出文本
//		String string = driver.findElementById("").getText().toString();
		
		//滑动
//		driver.scrollTo("");
		
//		driver.findElementByName("");
		*/
		
//		Thread.sleep(80000);
//		driver.close();
//		driver.quit();
	}
}