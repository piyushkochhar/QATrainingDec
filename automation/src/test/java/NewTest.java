
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvException;

public class NewTest {

	@Test()
	public void canGetBrowserTypeFromFile() throws Exception {
		ConfigurationProvider pv = new ConfigurationProvider();
		HashMap<String, String> config = pv.getPropertiesFromResourceFile("config.properties");
		String actualBrowserTypeValue = "chrome";

		String expectedBrowserTypeValue = config.get("BrowserType");

		Assert.assertEquals(actualBrowserTypeValue, expectedBrowserTypeValue);
	}
	
	@DataProvider(name = "modelMakeProvider")
	public Object[] getData() throws Exception {

		CSVReader reader = new CSVReaderBuilder(new FileReader(getCSVPath())).withSkipLines(1).build();

		HashMap<String, String> rows = new HashMap<String, String>();

		String[] row;
		while ((row = reader.readNext()) != null) {
			rows.put(row[1], row[0]);
		}
		reader.close();

		Object[][] objData = new Object[1][1];
		objData[0][0] = rows;

		return objData;
		
	}

	@Test(dataProvider = "modelMakeProvider")
	public void canGetHashData(HashMap h) throws IOException, CsvException {
		String expectedValue = "Warwick";

		String actualValue = (String) h.get("Corvette");
		
		Assert.assertEquals(actualValue, expectedValue);

	}

	@DataProvider(name = "csvProvider")
	public Object[] getCSVData() throws IllegalStateException, FileNotFoundException {
		List<MakeModel> makeModels = new CsvToBeanBuilder(new FileReader(getCSVPath()))
				.withType(MakeModel.class)
				.build()
				.parse();

		return makeModels.toArray();
	}
	
	@Test(dataProvider = "csvProvider")
	public void canGetCSVData(MakeModel m) throws IOException, CsvException {

		Assert.assertNotNull(m);

	}

	private String getCSVPath() {
		File f = new File("./");
		String path = f.getAbsolutePath().substring(0, f.getAbsolutePath().length() - 2)
				+ "/src/test/resources/basses.csv";
		return path;
	}

}
