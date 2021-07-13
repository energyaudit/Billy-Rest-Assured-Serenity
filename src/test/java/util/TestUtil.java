package util;


//import com.fasterxml.jackson.core.JsonGenerationException;
//import com.fasterxml.jackson.databind.JsonMappingException;
//import com.fasterxml.jackson.databind.JsonNode;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.jayway.jsonpath.Configuration;
//import com.jayway.jsonpath.DocumentContext;
//import com.jayway.jsonpath.EvaluationListener;
//import com.jayway.jsonpath.ReadContext;
//import com.jayway.jsonpath.spi.json.JacksonJsonNodeJsonProvider;
//import com.jayway.jsonpath.spi.mapper.JacksonMappingProvider;
//import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
//import org.apache.commons.io.FileUtils;
//import org.apache.poi.EncryptedDocumentException;
//import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
//import org.apache.poi.ss.usermodel.*;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.eclipse.paho.client.mqttv3.MqttClient;
//import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
//import org.eclipse.paho.client.mqttv3.MqttException;
//import org.eclipse.paho.client.mqttv3.MqttMessage;
//import org.javatuples.Quintet;
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
//import org.json.simple.parser.JSONParser;
import org.junit.Assert;

import java.io.*;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import static starter.stepdefinitions.StepDefinitions.*;

//import static com.verifone.cucumber.StepDefinitions.*;

public class TestUtil {

//    public static String getTodayOnFormat(String format) {
//        Date date = Calendar.getInstance().getTime();
//        // Display a date in day, month, year format
//        //DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
//        // DateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");
//        DateFormat formatter = new SimpleDateFormat(format);
//        String today = formatter.format(date);
//        System.out.println("Today : " + today);
//        return today;
//    }
//
//    public static List<String> linkedlist2ArraylistStr(LinkedList linkedlistin) {
//        // Converting LinkedList to ArrayList
//        List<String> list = new ArrayList<String>(linkedlistin);
//
//        for (String str : list) {
//            System.out.println(str);
//        }
//        return list;
//    }
//
//    public static Boolean arraylistContainStrVeri(List aList, String str) {
//        if (aList.contains(str)) {
//            System.out.println("The element " + str + " is available in the ArrayList");
//            return true;
//        } else {
//            System.out.println("The element " + str + " is not available in the ArrayList");
//            return false;
//        }
//    }
//
//    public static Boolean arraylistEleContainInputStr(List<String> aList, String str) {
//        Boolean found = false;
//        for (String s : aList) {
//            if (s.contains(str)) {
//                System.out.println("The element " + str + " is available in the ArrayList");
//                found = true;
//                break;
//            }
//        }
//        if (found) {
//            System.out.println("Found");
//        } else {
//            System.out.println("The element " + str + " is not available in the ArrayList");
//        }
//        return found;
//    }
//
//    public static List<String> filterListContainSpecificStrVeri(List<String> inputlist, String str) {
//        List<String> containStr = inputlist.stream()
//                .filter(s -> s.contains(str))
//                .collect(Collectors.toList());
//        System.out.println("After filtering, The new list contain " + str + "is:  ");
//        containStr.forEach(System.out::println);//method reference
//        return containStr;
//    }
//
//    public static void filesCopyFolder2Folder(String srcPath, String destPath) {
//        try {
//            // source & destination directories
//            File src = new File(srcPath);
//            File dest = new File(destPath);
//            // copy all files and folders from `src` to `dest`
//            FileUtils.copyDirectory(src, dest);
//
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
//    }
//
//    public static ArrayList<String> ArrayListStrDescendingSortVeri(ArrayList<String> arrayList) {
//        System.out.println("ArrayList Before Sorting:");
//        for (String str : arrayList) {
//            System.out.println(str);
//        }
//        /* Sorting in decreasing (descending) order*/
//        Collections.sort(arrayList, Collections.reverseOrder());
//        System.out.println("ArrayList in descending order:");
//        for (String str : arrayList) {
//            System.out.println(str);
//        }
//        return arrayList;
//    }
//
//    public static ArrayList ArrayListAscendingSortVeri(ArrayList arrayList) {//Arraylist is general,it can be either integer or string
//        Iterator iterator1 = arrayList.iterator();
//        System.out.println("Collection elements before sorting: \n");
//        while (iterator1.hasNext()) {
//            System.out.println(iterator1.next());
//        }
//        //Call the Collections sort method for sorting
//        Collections.sort(arrayList);
//        Iterator iterator2 = arrayList.iterator();
//        System.out.println("Collection elements after sorting:\n");
//        while (iterator2.hasNext()) {
//            System.out.println(iterator2.next());
//        }
//        return arrayList;
//    }
//
//    public static ArrayList<String> subStrArrayListMN(ArrayList<String> listStr, Integer M, Integer N) {
//        ArrayList<String> listSubStr = new ArrayList<>();
//        for (String str : listStr) {
//            listSubStr.add(str.substring(M, N));
//        }
//        for (String str : listSubStr) {
//            System.out.println(str);
//        }
//        return listSubStr;
//    }
//
//    public static Boolean arrayListCompareANIntVeri(ArrayList<String> listStr, String operator, Integer benchmark) {
//        Boolean compare = false;
//        switch (operator) {
//            case "<=":
//                ArrayList<Integer> listInt = new ArrayList<Integer>();
//                for (String str : listStr) {
//                    listInt.add(Integer.parseInt(str));
//                }
//                System.out.println("max in list is :" + Collections.max(listInt));
//                if (Collections.max(listInt) <= benchmark) {
//                    compare = true;
//
//                }
//                break;
//            case ">=":
//                ArrayList<Integer> listInt1 = new ArrayList<Integer>();
//                for (String str1 : listStr) {
//                    listInt1.add(Integer.parseInt(str1));
//                }
//                if (Collections.max(listInt1) >= benchmark) {
//                    compare = true;
//                }
//                break;
//            case "=":
//                for (String str2 : listStr) {
//                    if (Integer.parseInt(str2) < benchmark || Integer.parseInt(str2) > benchmark) {
//                        compare = false;
//                    } else {
//                        compare = true;
//                    }
//                    break;
//                }
//        }
//        System.out.println("The whole arraylist" + listStr + operator + benchmark + " :  " + compare);
//        return compare;
//    }
//
//    public static long betweenDaysVeri(String dateBeforeString, String dateAfterString) {
//        //Parsing the date
//        LocalDate dateBefore = LocalDate.parse(dateBeforeString);
//        LocalDate dateAfter = LocalDate.parse(dateAfterString);
//
//        //calculating number of days in between
//        long noOfDaysBetween = ChronoUnit.DAYS.between(dateBefore, dateAfter);
//        //displaying the number of days
//        System.out.println(noOfDaysBetween);
//        return noOfDaysBetween;
//    }
//
//    public static String convertDateFormatVeri(String fromDateFormat, String toDateFormat,
//                                               String date) {
//        SimpleDateFormat format1 = new SimpleDateFormat(fromDateFormat);
//        SimpleDateFormat format2 = new SimpleDateFormat(toDateFormat);
//        Date dateParse = null;
//        try {
//            dateParse = format1.parse(date);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        String convert = format2.format(dateParse);
//        System.out.println(convert);
//        return convert;
//    }
//
//    public static String getFiledByJpath(String data, String Jpath) {
//        JsonPath jsonPath = new JsonPath(data);
//        String filed = jsonPath.getString(Jpath);
//        System.out.println("the field is: " + filed);
//        return filed;
//    }
//
//    public static ArrayList DB2Arraylist(ArrayList a, String dburl, String user, String pwd, Integer column, String query) throws ClassNotFoundException, SQLException, JsonGenerationException, JsonMappingException, IOException, JSONException {
//        // TODO Auto-generated method stub
//        Class.forName("com.mysql.cj.jdbc.Driver");
//        Connection conn = null;
////        conn = DriverManager.getConnection("jdbc:postgresql://" + dburl + "/postgres", user, pwd);
//        conn = DriverManager.getConnection("jdbc:postgresql://" + dburl, user, pwd);
//        Statement st = conn.createStatement();
//        ResultSet rs = st.executeQuery(query);
//        while (rs.next()) {
//            a.add(rs.getString(column));
//        }
//        conn.close();
//        return a;
//    }
//
//    public static Map DB2Map(Map a, String dburl, String user, String pwd, Integer KeyColumn, Integer ValueColumn, String query) throws ClassNotFoundException, SQLException, JsonGenerationException, JsonMappingException, IOException, JSONException {
//        // TODO Auto-generated method stub
//        Class.forName("com.mysql.cj.jdbc.Driver");
//        Connection conn = null;
//        conn = DriverManager.getConnection("jdbc:postgresql://" + dburl, user, pwd);
//        //object of statement class will help to execute queries
//        Statement st = conn.createStatement();
//        ResultSet rs = st.executeQuery(query);
//        while (rs.next()) {
//            a.put(rs.getString(KeyColumn), rs.getString(ValueColumn));
//        }
//        conn.close();
//        return a;
//    }
//
//    public static Quintet DB2Quintet(String dburl, String user, String pwd, String query) throws ClassNotFoundException, SQLException, JsonGenerationException, JsonMappingException, IOException, JSONException {
//        // TODO Auto-generated method stub
//        Class.forName("com.mysql.cj.jdbc.Driver");
//        Connection conn = null;
//        conn = DriverManager.getConnection("jdbc:postgresql://" + dburl, user, pwd);
//        //object of statement class will help to execute queries
//        Statement st = conn.createStatement();
//        ResultSet rs = st.executeQuery(query);
//        Quintet<String, String, String, String, String> quintet = null;
//        if (rs.next()) {
//            quintet
//                    = Quintet.with(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
//        }
//        conn.close();
//        return quintet;
//    }
//
//
//    public static int getResSizebyResponse(Response resp, String jpath) {
////        org.apache.log4j.BasicConfigurator.configure();
//
//        int size = resp.jsonPath().getMap(jpath).size();
//        return size;
//    }
//
//    public static String JsonFile2Str(String path) {
//        String result = null;
//        try {
//            ObjectMapper mapper = new ObjectMapper();
//            JsonNode root = mapper.readTree(new File(path));
//            result = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(root);
//        } catch (JsonGenerationException e) {
//            e.printStackTrace();
//        } catch (JsonMappingException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return result;
//    }
//
//    public static ArrayList getListByNameFromJsonFile(String fpath, String nam) throws JSONException {
//        ArrayList<String> list = new ArrayList<String>();
//        ArrayList<JSONObject> json = new ArrayList<JSONObject>();
//        JSONObject obj;
//        String fileName = fpath;
//        // This will reference one line at a time
//        String line = null;
//        try {
//            // FileReader reads text files in the default encoding.
//            FileReader fileReader = new FileReader(fileName);
//            // Always wrap FileReader in BufferedReader.
//            BufferedReader bufferedReader = new BufferedReader(fileReader);
//            while ((line = bufferedReader.readLine()) != null) {
//                obj = (JSONObject) new JSONParser().parse(line);
//                json.add(obj);
//                String result = obj.get(nam).toString();
//                System.out.println(result);
//                list.add(result);
//            }
//            // Always close files.
//            bufferedReader.close();
//        } catch (FileNotFoundException ex) {
//            System.out.println("Unable to open file '" + fileName + "'");
//        } catch (IOException ex) {
//            System.out.println("Error reading file '" + fileName + "'");
//            // Or we could just do this:
//            // ex.printStackTrace();
//        } catch (org.json.simple.parser.ParseException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        return list;
//    }
//
    public static void Jsonstr2FileVeri(String JsonStr, String filepath) {
        try {
            FileWriter w = new FileWriter(filepath);
            BufferedWriter out = new BufferedWriter(w);
            out.write(JsonStr);
            out.flush();
            out.close();
        } catch (IOException e) {
            System.out.println("exception " + e.getMessage());
            e.printStackTrace();
        }

    }
//
//    public static List<String> getJsonPathsByFieldNameVeri(String filepath, String[] stringArray) throws IOException {
//        File jsonFile = new File(filepath).getAbsoluteFile();
//        List<String> paths = new ArrayList<>();
//        ReadContext findPathsContext = com.jayway.jsonpath.JsonPath.parse(jsonFile).withListeners((found) -> {
//            paths.add(found.path());
//            return EvaluationListener.EvaluationContinuation.CONTINUE;
//        });
//        List<String> properties = Arrays.asList(stringArray);
//        properties.forEach(p -> findPathsContext.read("$.." + p));
//        return paths;
//    }
//
//    public static List<String> getJsonPathsFrmJsonByFieldKey(String jsonStr, String[] stringArray) throws IOException {
//        List<String> paths = new ArrayList<>();
//        ReadContext findPathsContext = com.jayway.jsonpath.JsonPath.parse(jsonStr).withListeners((found) -> {
//            paths.add(found.path());
//            return EvaluationListener.EvaluationContinuation.CONTINUE;
//        });
//        List<String> properties = Arrays.asList(stringArray);
//        properties.forEach(p -> findPathsContext.read("$.." + p));
//        return paths;
//    }
//
//    public boolean ListStrContainsVeri(List<String> arr, String y) {
//        boolean contains = arr.contains(y);
//        return contains;
//    }
//
//    public static <K, V> Set<K> getKeysVeri(Map<K, V> map, V value) {
//        Set<K> keys = new HashSet<>();
//        for (Map.Entry<K, V> entry : map.entrySet()) {
//            if (entry.getValue().equals(value)) {
//                keys.add(entry.getKey());
//            }
//        }
//        return keys;
//    }
//
//    public void appendExcelCellValuesVeri(String filePath, Object[][] append, Integer sheetIndex) {
//        try {
//            FileInputStream inputStream = new FileInputStream(new File(filePath));
//            Workbook workbook = WorkbookFactory.create(inputStream);
//            Sheet sheet = workbook.getSheetAt(sheetIndex);
//
//            int rowCount = sheet.getLastRowNum();
//            for (Object[] aBook : append) {
//                Row row = sheet.createRow(++rowCount);
//                int columnCount = 0;
//                Cell cell = row.createCell(columnCount);
//                cell.setCellValue(rowCount);
//
//                for (Object field : aBook) {
//                    cell = row.createCell(++columnCount);
//                    if (field instanceof String) {
//                        cell.setCellValue((String) field);
//                    } else if (field instanceof Integer) {
//                        cell.setCellValue((Integer) field);
//                    }
//                }
//
//            }
//
//            inputStream.close();
//            FileOutputStream outputStream = new FileOutputStream(filePath);
//            workbook.write(outputStream);
//            workbook.close();
//            outputStream.close();
//
//        } catch (IOException | EncryptedDocumentException
//                | InvalidFormatException ex) {
//            ex.printStackTrace();
//        }
//    }
//
//    public boolean mapContainKeyVeri(Map map, String key) {
//        boolean present = map.containsKey(key);
//        System.out.println("Is the key  present? "
//                + present);
//        return present;
//    }
//
//    public boolean mapContainValueVeri(Map map, String value) {
//        boolean present = map.containsValue(value);
//        System.out.println("Is the value present? "
//                + present);
//        return present;
//    }
//
//    public String selectTokenByIndex(int merchantIndex) {
//        String token = null;
//        switch (merchantIndex) {
//            case 1:
//                token = merchantAdmin1Token;
//                break;
//            case 2:
//                token = merchantAdmin2Token;
//                break;
//        }
//        System.out.println("The token use for this scenario is : " + token);
//        return token;
//    }
//
//    public String selectTokenByName(String tokenName) {
//        String token = null;
//        switch (tokenName) {
//            case "merchantAdmin1Token":
//                token = merchantAdmin1Token;
//                break;
//            case "merchantAdmin2Token":
//                token = merchantAdmin2Token;
//                break;
//            case "merchantAdmin3Token":
//                token = merchantAdmin3Token;
//                break;
//            case "majorOilAdmin1Token":
//                token = majorOilAdmin1Token;
//                break;
//            case "majorOilAdmin2Token":
//                token = majorOilAdmin2Token;
//                break;
//            case "majorOilAdminSubToken":
//                token = majorOilAdminSubToken;
//                break;
//        }
//        System.out.println("The token use for this scenario is : " + token);
//        return token;
//    }
//
//    public static void appendJsonStr2FileVeri(String JsonStr, String filepath) {
//        try {
//
//            FileWriter w = new FileWriter(filepath, true);
//            BufferedWriter out = new BufferedWriter(w);
//            out.write(",");
//            out.newLine();
//            out.write(JsonStr);
//            out.newLine();
//            out.flush();
//            out.close();
//        } catch (IOException e) {
//            System.out.println("exception " + e.getMessage());
//            e.printStackTrace();
//        }
//    }
//
//    public static List listDifferenceVeri(List a, List b) {
//        List toReturn = new ArrayList(a);
//        toReturn.removeAll(b);
//        System.out.println(toReturn);
//        return toReturn;
//    }

    public static String getTypesOfGetResponseToFilePath(String AccountType, int index, String fileFolderPath, String testName, String url) {
        ResponseBody rsb = new ResponseBody();
        Response response = null;
        TestUtil tul = new TestUtil();
        String token = null;
        String fileResponse = null;
        switch (AccountType) {
            case "Brand Oil":
                switch (index) {
                    case 1:
                        token = majorOilAdmin1Token;
                        response = rsb.getWithHeadersMethod(token, url);
//                    tul.Jsonstr2FileVeri(response.asString(), "src/test/testresult/BrandHierarchyResponse1.json");
                        fileResponse = fileFolderPath + "/Brand" + testName + "Response1.json";
                        System.out.println("fileResponse is : " + fileResponse);
                        tul.Jsonstr2FileVeri(response.asString(), fileResponse);
                        Assert.assertEquals(200, response.getStatusCode());
                        break;
                    case 2:
                        token = majorOilAdmin2Token;
                        response = rsb.getWithHeadersMethod(token, url);
//                    tul.Jsonstr2FileVeri(response.asString(), "src/test/testresult/BrandHierarchyResponse2.json");
                        fileResponse = fileFolderPath + "/Brand" + testName + "Response2.json";
                        System.out.println("fileResponse is : " + fileResponse);
                        tul.Jsonstr2FileVeri(response.asString(), fileResponse);
                        Assert.assertEquals(200, response.getStatusCode());
                        break;

                }
                break;
            case "Merchant":
                switch (index) {
                    case 1:
                        token = merchantAdmin1Token;
                        response = rsb.getWithHeadersMethod(token, url);
//                    tul.Jsonstr2FileVeri(response.asString(), "src/test/testresult/hierarchyResponse1.json");
                        fileResponse = fileFolderPath + "/Merchant" + testName + "Response1.json";
                        tul.Jsonstr2FileVeri(response.asString(), fileResponse);
                        Assert.assertEquals(200, response.getStatusCode());
                        break;
                    case 2:
                        token = merchantAdmin2Token;
                        response = rsb.getWithHeadersMethod(token, url);
//                    tul.Jsonstr2FileVeri(response.asString(), "src/test/testresult/MerHierarchyResponse2.json");
                        fileResponse = fileFolderPath + "/Merchant" + testName + "Response2.json";
                        tul.Jsonstr2FileVeri(response.asString(), fileResponse);
                        Assert.assertEquals(200, response.getStatusCode());
                        break;
                    case 3:
                        token = merchantAdmin3Token;
                        response = rsb.getWithHeadersMethod(token, url);
//                    tul.Jsonstr2FileVeri(response.asString(), "src/test/testresult/MerHierarchyResponse3.json");
                        fileResponse = fileFolderPath + "/Merchant" + testName + "Response3.json";
                        System.out.println("The response is: " + response.getBody().asString());
                        System.out.println("fileResponse is : " + fileResponse);
                        tul.Jsonstr2FileVeri(response.asString(), fileResponse);
                        Assert.assertEquals(200, response.getStatusCode());
                        break;

                }
                break;
            case "TestToken":

                response = rsb.getWithHeadersMethod(TestToken, url);
//                    tul.Jsonstr2FileVeri(response.asString(), "src/test/testresult/MerHierarchyResponse3.json");
                TestTokenResponseFilePath = fileFolderPath + "/" + testName + "Response.json";
                System.out.println("The response is: " + response.getBody().asString());
                System.out.println("fileResponse is : " + TestTokenResponseFilePath);
                tul.Jsonstr2FileVeri(response.asString(), TestTokenResponseFilePath);
                Assert.assertEquals(200, response.getStatusCode());
                break;
        }
        return response.asString();
    }

//    public static String patchResponseToFilePath(String AccountType, int index, String requestBody, String fileFolderPath, String testName, String url) {
//        RestponsePatchVeri rsb = new RestponsePatchVeri();
//        Response response = null;
//        TestUtil tul = new TestUtil();
//        String token = null;
//        String fileResponse = null;
//        switch (AccountType) {
//            case "Brand Oil":
//                switch (index) {
//                    case 1:
//                        token = majorOilAdmin1Token;
//                        response = rsb.patchWithPaylaod(requestBody, token, url);
//                        fileResponse = fileFolderPath + "/Brand" + testName + "Response1.json";
//                        System.out.println("fileResponse is : " + fileResponse);
//                        tul.Jsonstr2FileVeri(response.asString(), fileResponse);
//                        Assert.assertEquals(200, response.getStatusCode());
//                        break;
//                    case 2:
//                        token = majorOilAdmin2Token;
//                        response = rsb.patchWithPaylaod(requestBody, token, url);
//                        fileResponse = fileFolderPath + "/Brand" + testName + "Response2.json";
//                        System.out.println("fileResponse is : " + fileResponse);
//                        tul.Jsonstr2FileVeri(response.asString(), fileResponse);
//                        Assert.assertEquals(200, response.getStatusCode());
//                        break;
//
//                }
//                break;
//            case "Merchant":
//                switch (index) {
//                    case 1:
//                        token = merchantAdmin1Token;
//                        rsb.patchWithPaylaod(requestBody, token, url);
//                        fileResponse = fileFolderPath + "/Merchant" + testName + "Response1.json";
//                        tul.Jsonstr2FileVeri(response.asString(), fileResponse);
//                        Assert.assertEquals(200, response.getStatusCode());
//                        break;
//                    case 2:
//                        token = merchantAdmin2Token;
//                        rsb.patchWithPaylaod(requestBody, token, url);
//                        fileResponse = fileFolderPath + "/Merchant" + testName + "Response2.json";
//                        tul.Jsonstr2FileVeri(response.asString(), fileResponse);
//                        Assert.assertEquals(200, response.getStatusCode());
//                        break;
//                    case 3:
//                        token = merchantAdmin3Token;
//                        rsb.patchWithPaylaod(requestBody, token, url);
//                        fileResponse = fileFolderPath + "/Merchant" + testName + "Response3.json";
//                        System.out.println("The response is: " + response.getBody().asString());
//                        System.out.println("fileResponse is : " + fileResponse);
//                        tul.Jsonstr2FileVeri(response.asString(), fileResponse);
//                        Assert.assertEquals(200, response.getStatusCode());
//                        break;
//
//                }
//                break;
//        }
//        return response.asString();
//    }
//
//    public static String patchWithoutPayloadResponseToFilePath(String AccountType, int index, String fileFolderPath, String testName, String url) {
//        RestponsePatchVeri rsb = new RestponsePatchVeri();
//        Response response = null;
//        TestUtil tul = new TestUtil();
//        String token = null;
//        String fileResponse = null;
//        switch (AccountType) {
//            case "Brand Oil":
//                switch (index) {
//                    case 1:
//                        token = majorOilAdmin1Token;
//                        response = rsb.patchWithoutPaylaod(token, url);
//                        fileResponse = fileFolderPath + "/Brand" + testName + "Response1.json";
//                        System.out.println("fileResponse is : " + fileResponse);
//                        tul.Jsonstr2FileVeri(response.asString(), fileResponse);
//                        Assert.assertEquals(200, response.getStatusCode());
//                        break;
//                    case 2:
//                        token = majorOilAdmin2Token;
//                        response = rsb.patchWithoutPaylaod(token, url);
//                        fileResponse = fileFolderPath + "/Brand" + testName + "Response2.json";
//                        System.out.println("fileResponse is : " + fileResponse);
//                        tul.Jsonstr2FileVeri(response.asString(), fileResponse);
//                        Assert.assertEquals(200, response.getStatusCode());
//                        break;
//
//                }
//                break;
//            case "Merchant":
//                switch (index) {
//                    case 1:
//                        token = merchantAdmin1Token;
//                        response = rsb.patchWithoutPaylaod(token, url);
//                        fileResponse = fileFolderPath + "/Merchant" + testName + "Response1.json";
//                        tul.Jsonstr2FileVeri(response.asString(), fileResponse);
//                        Assert.assertEquals(200, response.getStatusCode());
//                        break;
//                    case 2:
//                        token = merchantAdmin2Token;
//                        response = rsb.patchWithoutPaylaod(token, url);
//                        fileResponse = fileFolderPath + "/Merchant" + testName + "Response2.json";
//                        tul.Jsonstr2FileVeri(response.asString(), fileResponse);
//                        Assert.assertEquals(200, response.getStatusCode());
//                        break;
//                    case 3:
//                        token = merchantAdmin3Token;
//                        response = rsb.patchWithoutPaylaod(token, url);
//                        fileResponse = fileFolderPath + "/Merchant" + testName + "Response3.json";
//                        System.out.println("The response is: " + response.getBody().asString());
//                        System.out.println("fileResponse is : " + fileResponse);
//                        tul.Jsonstr2FileVeri(response.asString(), fileResponse);
//                        Assert.assertEquals(200, response.getStatusCode());
//                        break;
//
//                }
//                break;
//        }
//        return response.asString();
//    }
//
//    public static void mqttPublishMessage(String broker, int qos, MqttClient client, String clientId, String content, String pubTopic) {
//        try {
//            MqttConnectOptions connOpts = new MqttConnectOptions();
//            connOpts.setCleanSession(true);
//            System.out.println("Connecting to broker: " + broker);
//            client.connect(connOpts);
//            System.out.println("Connected");
//            System.out.println("Publishing message: " + content);
//            MqttMessage message = new MqttMessage(content.getBytes());
//            message.setRetained(true); //sets retained message
//            message.setQos(qos);
//            client.publish(pubTopic, message);
//            System.out.println("Message published");
//            client.disconnect();
//            System.out.println("Disconnected");
////            client.close();
////            System.exit(0);
//        } catch (MqttException me) {
//            System.out.println("reason " + me.getReasonCode());
//            System.out.println("msg " + me.getMessage());
//            System.out.println("loc " + me.getLocalizedMessage());
//            System.out.println("cause " + me.getCause());
//            System.out.println("excep " + me);
//            me.printStackTrace();
//        }
//
//    }
//
//    public static void mqttPublishSubMessage(String broker, int qos, MqttClient client, String clientId, String content, String pubTopic, String subTopic) {
//        try {
////            MqttClient client = new MqttClient(broker, clientId, persistence);
//            // MQTT connection option
//            MqttConnectOptions connOpts = new MqttConnectOptions();
////            connOpts.setUserName("emqx_test");
////            connOpts.setPassword("emqx_test_password".toCharArray());
//            // retain session
//            connOpts.setCleanSession(true);
//
//            // set callback
//            client.setCallback(new PushCallback());
//
//
//            // establish a connection
//            System.out.println("Connecting to broker: " + broker);
//            client.connect(connOpts);
//
//            System.out.println("Connected");
//            System.out.println("Publishing message: " + content);
//
//            // Subscribe
//            client.subscribe(subTopic);
//
//            // Required parameters for message publishing
//            MqttMessage message = new MqttMessage(content.getBytes());
//            message.setQos(qos);
//            message.setRetained(true); //sets retained message
//            client.publish(pubTopic, message);
//            System.out.println("Message published");
//
//            client.disconnect();
//            System.out.println("Disconnected");
//            client.close();
////            System.exit(0);
//        } catch (MqttException me) {
//            System.out.println("reason " + me.getReasonCode());
//            System.out.println("msg " + me.getMessage());
//            System.out.println("loc " + me.getLocalizedMessage());
//            System.out.println("cause " + me.getCause());
//            System.out.println("excep " + me);
//            me.printStackTrace();
//        }
//
//    }
//
//    public static void mqttSubMessage(String broker, int qos, MqttClient client, String clientId, String subTopic) {
//        try {
////            MemoryPersistence persistence = new MemoryPersistence();
////            MqttClient client = new MqttClient(broker, clientId, persistence);
////             MQTT connection option
//            MqttConnectOptions connOpts = new MqttConnectOptions();
////            connOpts.setUserName("emqx_test");
////            connOpts.setPassword("emqx_test_password".toCharArray());
//            // retain session
//            connOpts.setCleanSession(true);
//
//            // set callback
//            client.setCallback(new PushCallback());
//
//            // establish a connection
//            System.out.println("Connecting to broker: " + broker);
//            client.connect(connOpts);
//
//            System.out.println("Connected");
//
//
//            // Subscribe
//            client.subscribe(subTopic);
//
//            // Required parameters for message publishing
////            MqttMessage message = new MqttMessage(content.getBytes());
////            message.setQos(qos);
////            client.publish(pubTopic, message);
////            System.out.println("Message published");
//
//            client.disconnect();
//            System.out.println("Disconnected");
////            client.close();
////            System.exit(0);
//        } catch (MqttException me) {
//            System.out.println("reason " + me.getReasonCode());
//            System.out.println("msg " + me.getMessage());
//            System.out.println("loc " + me.getLocalizedMessage());
//            System.out.println("cause " + me.getCause());
//            System.out.println("excep " + me);
//            me.printStackTrace();
//        }
//
//    }
//
//    public static int getRandomNumberInRangeVeri(int min, int max) {
//        if (min >= max) {
//            throw new IllegalArgumentException("max must be greater than min");
//        }
//        int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
//        return randomNum;
//    }
//
//    public static JSONArray getJSONArrayFromResponseVeri(String APIresponse, String path) throws JSONException {
//        JSONObject JsonArray = new JSONObject(APIresponse);
//        JSONArray JArray = JsonArray.getJSONArray(path);
//        return JArray;
//    }
//
//    public static String getJsonFiledFromResponseVeri(String APIresponse, String path) throws JSONException {
//        Configuration configuration = Configuration.builder().jsonProvider(new JacksonJsonNodeJsonProvider())
//                .mappingProvider(new JacksonMappingProvider()).build();
//        DocumentContext json = com.jayway.jsonpath.JsonPath.using(configuration).parse(APIresponse);
//        String JsonField = json.read(path).toString();
//        System.out.println("The json filed is :" + JsonField);
//        return JsonField;
//    }


}
