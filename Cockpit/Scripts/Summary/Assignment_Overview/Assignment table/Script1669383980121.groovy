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
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory

WebUI.openBrowser('')

WebUI.maximizeWindow()

WebDriver driver = DriverFactory.getWebDriver()


WebUI.navigateToUrl('http://192.168.3.50:33311/')

WebUI.setText(findTestObject('Page_/input_Almasons Consulting LLC_CLIENTID'), GlobalVariable.Client)

WebUI.setText(findTestObject('Page_/input_Almasons Consulting LLC_USERNAME'), GlobalVariable.userID)

WebUI.setText(findTestObject('Page_/input_Almasons Consulting LLC_password'), GlobalVariable.Password)

WebUI.click(findTestObject('Page_/button_Login'))

validate = WebUI.verifyElementVisible(findTestObject('Page_/Verify Client'))

WebUI.verifyElementText(findTestObject('Page_/Verify Client'), 'SMD')

WebUI.click(findTestObject('Hamburger/Page_User GiNi Cockpit/i_SMD_fas fa-bars'))

WebUI.click(findTestObject('Page_User GiNi Cockpit/Admin'))

WebUI.click(findTestObject('Page_User GiNi Cockpit/Reports'))

WebUI.click(findTestObject('Summary/Page_User GiNi Cockpit/div_Summary1'))

WebUI.click(findTestObject('Page_Summary GiNi Cockpit(Assignment Overview)/i_SMD_fas fa-times'))

WebUI.verifyElementPresent(findTestObject('Page_Summary GiNi Cockpit(Assignment Overview)/h4_Assignment Overview'), 0)

WebUI.verifyElementText(findTestObject('Page_Summary GiNi Cockpit(Assignment Overview)/h4_Assignment Overview'), 'Assignment Overview')
//*[@id="Grid_AssignmentOverview_content_table"]/tbody

WebElement Table = driver.findElement(By.xpath("//*[@id=\"Grid_AssignmentOverview_content_table\"]/tbody"))

List<WebElement> rows_table = Table.findElements(By.tagName('tr'))

'To calculate no of rows In table'
int rows_count = rows_table.size()
 
'Loop will execute for all the rows of the table'

println(rows_count)

for (int row = 0; row < rows_count; row++) {
	'To locate columns(cells) of that specific row'
	List<WebElement> Columns_row = rows_table.get(row).findElements(By.tagName('td'))
	
	int columns_count = Columns_row.size()
	println((('Number of cells In Row ' + row) + ' are ') + columns_count)
	
   'Loop will execute till the last cell of that specific row'
   for (int column = 0; column < columns_count; column++) {
   'It will retrieve text from each cell'
   String celltext = Columns_row.get(column).getText()
   println((((('Cell Value Of row number ' + row) + ' and column number ') + column) + ' Is ') + celltext )
   }
}
	




