package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import helpers.RowOnStucturePage;
import pages.*;
import seleniumCore.TestBase;

public class PhpMyAdminTest extends TestBase {
	IndexPage indexPage;
	DatabasesPage databasesPage;
	TableNamePage tableNamePage;
	RowOnStucturePage rowOnStucturePage;
	TableCreateStructurePage tableCreateStructurePage;
	DataInsertPage dataInsertPage;
	int countInfillTableWithDataMethod = 0;

	@DataProvider(name = "TableStructureDataProvider")
	public Object[][] createStuctureData() {
		return new Object[][] {
				{ new Integer(0), new String("u_id"), new String("INT"), new String("11"), new String("1") },
				{ new Integer(1), new String("u_login"), new String("VARCHAR"), new String("255"), new String("0") },
				{ new Integer(2), new String("u_password"), new String("CHAR"), new String("40"), new String("0") },
				{ new Integer(3), new String("u_email"), new String("VARCHAR"), new String("255"), new String("0") },
				{ new Integer(4), new String("u_name"), new String("VARCHAR"), new String("255"), new String("0") },
				{ new Integer(5), new String("u_remember"), new String("CHAR"), new String("40"), new String("0") }, };
	}

	@DataProvider(name = "InsertIntoTableDataProvider")
	public Object[][] insertIntoTableData() {
		return new Object[][] {
				{ new String("user1"), new String("e38ad214943daad1d64c102faec29de4afe9da3d"),
						new String("user1@mail.com"), new String("Pupkin") },
				{ new String("user2"), new String("2aa60a8ff7fcd473d321e0146afd9e26df395147"),
						new String("user2@mail.com"), new String("Smith") }, };
	}

	@Test(priority = 1)
	public void login() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.chooseEnglishLanguage();
		 loginPage.login("root", "root");
		 indexPage = new IndexPage(driver);
	}

	@Test(priority = 2)
	public void createDatabase() {
		indexPage.openDatabases();
		databasesPage = new DatabasesPage(driver);
		databasesPage.createDB("auth");
		tableNamePage = new TableNamePage(driver);
		tableNamePage.submitNewTableName("users", "6");

	}

	@Test(priority = 3, dataProvider = "TableStructureDataProvider")
	public void fillStructure(Integer number, String name, String type, String value, String ai) {

		rowOnStucturePage = new RowOnStucturePage(number, name, type, value, ai);
		tableCreateStructurePage = new TableCreateStructurePage(driver, rowOnStucturePage);
		tableCreateStructurePage.fillRows();
	}

	@Test(priority = 4)
	public void finishStructureCreatingAndCheck() {

		tableCreateStructurePage.setEncodindAndSubmit();

		TableEditStructurePage tableEditStructurePage = new TableEditStructurePage(driver);

		Assert.assertEquals(tableEditStructurePage.textNameOfId.getText().contains("u_id"), true);
		Assert.assertEquals(tableEditStructurePage.textNameOfLogin.getText().contains("u_login"), true);
		Assert.assertEquals(tableEditStructurePage.textNameOfPassword.getText().contains("u_password"), true);
		Assert.assertEquals(tableEditStructurePage.textNameOfEmail.getText().contains("u_email"), true);
		Assert.assertEquals(tableEditStructurePage.textNameOfName.getText().contains("u_name"), true);
		Assert.assertEquals(tableEditStructurePage.textNameOfRemember.getText().contains("u_remember"), true);

		Assert.assertEquals(tableEditStructurePage.textTypeOfId.getText().contains("int(11)"), true);
		Assert.assertEquals(tableEditStructurePage.textTypeOfLogin.getText().contains("varchar(255)"), true);
		Assert.assertEquals(tableEditStructurePage.textTypeOfPassword.getText().contains("char(40)"), true);
		Assert.assertEquals(tableEditStructurePage.textTypeOfEmail.getText().contains("varchar(255)"), true);
		Assert.assertEquals(tableEditStructurePage.textTypeOfName.getText().contains("varchar(255)"), true);
		Assert.assertEquals(tableEditStructurePage.textTypeOfRemember.getText().contains("char(40)"), true);

		Assert.assertEquals(tableEditStructurePage.textNullOfId.getText().contains("No"), true);
		Assert.assertEquals(tableEditStructurePage.textNullOfLogin.getText().contains("No"), true);
		Assert.assertEquals(tableEditStructurePage.textNullOfPassword.getText().contains("No"), true);
		Assert.assertEquals(tableEditStructurePage.textNullOfEmail.getText().contains("No"), true);
		Assert.assertEquals(tableEditStructurePage.textNullOfName.getText().contains("No"), true);
		Assert.assertEquals(tableEditStructurePage.textNullOfRemember.getText().contains("No"), true);

		Assert.assertEquals(tableEditStructurePage.textAIOfId.getText().contains("AUTO_INCREMENT"), true);
		
		Assert.assertEquals(tableEditStructurePage.textCollationOfLogin.getText().contains("utf8_general_ci"), true);
		Assert.assertEquals(tableEditStructurePage.textCollationOfPassword.getText().contains("utf8_general_ci"), true);
		Assert.assertEquals(tableEditStructurePage.textCollationOfEmail.getText().contains("utf8_general_ci"), true);
		Assert.assertEquals(tableEditStructurePage.textCollationOfName.getText().contains("utf8_general_ci"), true);
		Assert.assertEquals(tableEditStructurePage.textCollationOfRemember.getText().contains("utf8_general_ci"), true);
	}

	@Test(priority = 5)
	public void openInputDataForm() {

		driver.get(BaseURL);
		indexPage = new IndexPage(driver);
		indexPage.openDatabases();
		databasesPage.chooseAuthDB();
		tableNamePage = new TableNamePage(driver);
		tableNamePage.chooseFirstInsertLink();
		dataInsertPage = new DataInsertPage(driver);
	}

	@Test(priority = 6, dataProvider = "InsertIntoTableDataProvider")
	public void fillTableWithData(String login, String password, String email, String name) {

		dataInsertPage.fillForm(login, password, email, name);

		if (countInfillTableWithDataMethod == 0) {
			tableNamePage.chooseFirstInsertLink();
			countInfillTableWithDataMethod++;
		}
		
		
		
	}
	@Test(priority = 7)
	public void checkData(){
		driver.get(BaseURL);
		indexPage.openDatabases();
		databasesPage.chooseAuthDB();
		tableNamePage.openFirstTable();
		DataEditPage dataEditPage = new DataEditPage(driver);
		Assert.assertEquals(dataEditPage.textLoginOfFirstRecord.getText().contains("user1"), true);
		Assert.assertEquals(dataEditPage.textLoginOfSecondRecord.getText().contains("user2"), true);
		
		Assert.assertEquals(dataEditPage.textPasswordOfFirstRecord.getText().contains("e38ad214943daad1d64c102faec29de4afe9da3d"), true);
		Assert.assertEquals(dataEditPage.textPasswordOfSecondRecord.getText().contains("2aa60a8ff7fcd473d321e0146afd9e26df395147"), true);
		
		Assert.assertEquals(dataEditPage.textEmailOfFirstRecord.getText().contains("user1@mail.com"), true);
		Assert.assertEquals(dataEditPage.textEmailOfSecondRecord.getText().contains("user2@mail.com"), true);
		
		Assert.assertEquals(dataEditPage.textNameOfFirstRecord.getText().contains("Pupkin"), true);
		Assert.assertEquals(dataEditPage.textNameOfSecondRecord.getText().contains("Smith"), true);
		
		Assert.assertEquals(dataEditPage.textRememberOfFirstRecord.getText().equals(""), true);
		Assert.assertEquals(dataEditPage.textRememberOfSecondRecord.getText().equals(""), true);
	}
	@Test(priority = 8)
	public void dropDB() {
		driver.get(BaseURL);
		indexPage.openDatabases();
		databasesPage.dropAuthDB();

	}
}
