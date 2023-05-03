import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import groovy.json.JsonSlurper as JsonSlurper

JsonSlurper slurper = new JsonSlurper()
File f = new File('data.json')
def InputJSON = new JsonSlurper().parseFile(f, 'UTF-8')

InputJSON.each({ 
        println(it)
    })

WebUI.callTestCase(findTestCase('User landing on Practice Form Page'), [('username') : 'username', ('password') : 'password'], FailureHandling.OPTIONAL)
for (def index : (0..2)) {
	String name = InputJSON.data.name[index]
	NewName = name.replace('[', '').replace(']', '')
	String phone = InputJSON.data.phone[index]
	NewPhone = phone.replace('[', '').replace(']', '')
	String email = InputJSON.data.email[index]
	NewEmail = email.replace('[', '').replace(']', '')
	String password = InputJSON.data.password[index]
	NewPassword = password.replace('[', '').replace(']', '')
	String address = InputJSON.data.address[index]
	NewAddress = address.replace('[', '').replace(']', '')
	
	WebUI.setText(findTestObject('Textarea practice/txt_name'), NewName)
	WebUI.setText(findTestObject('Textarea practice/txt_phone'), NewPhone)
	WebUI.setText(findTestObject('Textarea practice/txt_email'), NewEmail)
	WebUI.setText(findTestObject('Textarea practice/txt_password'), NewPassword)
	WebUI.setText(findTestObject('Textarea practice/txt_address'), NewAddress)
	WebUI.click(findTestObject('Textarea practice/btn_submit'))
	WebUI.delay(2)
}
WebUI.closeBrowser()

