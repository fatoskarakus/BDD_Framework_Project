package ExcelLibraries;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

public  class ExcelLibraries {

        public static String path = "C:/Users/FATMA/IdeaProjects/QA_Project/TestData/TestData.xlsx";

        public FileInputStream fis;
        public FileOutputStream fileOut;
        private XSSFWorkbook workbook;
        private XSSFSheet sheet;
        private XSSFRow row;
        private XSSFCell cell;

        public ExcelLibraries() {

            this.path = path;

            try {
                fis = new FileInputStream(path);
                workbook = new XSSFWorkbook(fis);
                sheet = workbook.getSheetAt(0);
                fis.close();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }


        public ExcelLibraries(String path) {

            this.path = path;
            try {
                fis = new FileInputStream(path);
                workbook = new XSSFWorkbook(fis);
                sheet = workbook.getSheetAt(0);
                fis.close();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        public String readOneData(String sheetName, int row, int col) throws IOException {
            sheet = workbook.getSheet(sheetName);
            String data = sheet.getRow(row).getCell(col).getStringCellValue();
            workbook.close();
            return data;
        }

        //read the from the excelTable
        public String readExcelTable(String sheetName) throws IOException {
            sheet = workbook.getSheet(sheetName);
            //String data = sheet.getRow(row).getCell(col).getStringCellValue();
            int rowCount = sheet.getLastRowNum();
            int colCount = sheet.getRow(0).getLastCellNum();

            String data = null;
            for (int i = 0; i < rowCount; i++) {
                Row satir = sheet.getRow(i);
                for (int j = 0; j < colCount; j++) {
                    data = satir.getCell(j).getStringCellValue();
                    System.out.print(data + "   ");
                }
                System.out.println();
            }
            workbook.close();
            return data;
        }


        public int getRowCount(String sheetName) {
            int index = workbook.getSheetIndex(sheetName);
            if (index == -1)
                return 0;
            else {
                sheet = workbook.getSheetAt(index);
                int number = sheet.getLastRowNum() + 1;
                return number;
            }
        }

            public String getCellData(String sheetName,String colName,int rowNum){
        try{
            if(rowNum <=0)
                return "";

            int index = workbook.getSheetIndex(sheetName);
            int col_Num=-1;
            if(index==-1)
                return "";

            sheet = workbook.getSheetAt(index);
            row=sheet.getRow(0);
            for(int i=0;i<row.getLastCellNum();i++){
                //System.out.println(row.getCell(i).getStringCellValue().trim());
                if(row.getCell(i).getStringCellValue().trim().equals(colName.trim()))
                    col_Num=i;
            }
            if(col_Num==-1)
                return "";

            sheet = workbook.getSheetAt(index);
            row = sheet.getRow(rowNum-1);
            if(row==null)
                return "";
            cell = row.getCell(col_Num);

            if(cell==null)
                return "";
            //System.out.println(cell.getCellType());
            if(cell.getCellType().name().equals("STRING"))
                return cell.getStringCellValue();
            else if(cell.getCellType().name().equals("NUMERIC") || cell.getCellType().name().equals("FORMULA") ){

                String cellText  = String.valueOf(cell.getNumericCellValue());
                if (HSSFDateUtil.isCellDateFormatted(cell)) {
                    // format in form of M/D/YY
                    double d = cell.getNumericCellValue();

                    Calendar cal =Calendar.getInstance();
                    cal.setTime(HSSFDateUtil.getJavaDate(d));
                    cellText =
                            (String.valueOf(cal.get(Calendar.YEAR))).substring(2);
                    cellText = cal.get(Calendar.DAY_OF_MONTH) + "/" +
                            cal.get(Calendar.MONTH)+1 + "/" +
                            cellText;

                    //System.out.println(cellText);

                }
                return cellText;
            }else if(cell.getCellType().name().equals("BLANK"))
                return "";
            else
                return String.valueOf(cell.getBooleanCellValue());

        }
        catch(Exception e){

            e.printStackTrace();
            return "row "+rowNum+" or column "+colName +" does not exist in xls";
        }
    }
 //returns true if sheet is created successfully else false
        public boolean addSheet(String sheetname) {

            FileOutputStream fileOut;
            try {
                workbook.createSheet(sheetname);
                fileOut = new FileOutputStream(path);
                workbook.write(fileOut);
                fileOut.close();
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
            return true;
        }

        // returns true if sheet is removed successfully else false if sheet does not exist
        public boolean removeSheet(String sheetName) {
            int index = workbook.getSheetIndex(sheetName);
            if (index == -1)
                return false;

            FileOutputStream fileOut;
            try {
                workbook.removeSheetAt(index);
                fileOut = new FileOutputStream(path);
                workbook.write(fileOut);
                fileOut.close();
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
            return true;
        }

        // returns true if column is created successfully
        public boolean addColumn(String sheetName, String colName) {
            //System.out.println("**************addColumn*********************");

            try {
                fis = new FileInputStream(path);
                workbook = new XSSFWorkbook(fis);
                int index = workbook.getSheetIndex(sheetName);
                if (index == -1)
                    return false;

                XSSFCellStyle style = workbook.createCellStyle();
                //style.setFillForegroundColor(HSSFColor.GREY_40_PERCENT.index);
                //style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

                sheet = workbook.getSheetAt(index);

                row = sheet.getRow(0);
                if (row == null)
                    row = sheet.createRow(0);

                //cell = row.getCell();
                //if (cell == null)
                //System.out.println(row.getLastCellNum());
                if (row.getLastCellNum() == -1)
                    cell = row.createCell(0);
                else
                    cell = row.createCell(row.getLastCellNum());

//            cell.setCellValue(colName);
//            cell.setCellStyle(style);

                fileOut = new FileOutputStream(path);
                workbook.write(fileOut);
                fileOut.close();

            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }

            return true;

        }

        // removes a column and all the contents
        public boolean removeColumn(String sheetName, int colNum) {
            try {
                // if(!isSheetExist(sheetName))
//                return false;
//           // fis = new FileInputStream(path);
//            workbook = new XSSFWorkbook(fis);
//            sheet=workbook.getSheet(sheetName);
//            XSSFCellStyle style = workbook.createCellStyle();
//            //style.setFillForegroundColor(HSSFColor.GREY_40_PERCENT.index);
                //XSSFCreationHelper createHelper = workbook.getCreationHelper();
                //style.setFillPattern(HSSFCellStyle.NO_FILL);


                for (int i = 0; i < getRowCount(sheetName); i++) {
                    row = sheet.getRow(i);
                    if (row != null) {
                        cell = row.getCell(colNum);
                        if (cell != null) {
//                        cell.setCellStyle(style);
//                        row.removeCell(cell);
                        }
                    }
                }
                fileOut = new FileOutputStream(path);
                workbook.write(fileOut);
                fileOut.close();
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
            return true;

        }

        // find whether sheets exists
        public boolean isSheetExist(String sheetName) {
            int index = workbook.getSheetIndex(sheetName);
            if (index == -1) {
                index = workbook.getSheetIndex(sheetName.toUpperCase());
                if (index == -1)
                    return false;
                else
                    return true;
            } else
                return true;
        }

        // returns number of columns in a sheet
        public int getColumnCount(String sheetName) {
            // check if sheet exists
            if (!isSheetExist(sheetName))
                return -1;

            sheet = workbook.getSheet(sheetName);
            row = sheet.getRow(0);

            if (row == null)
                return -1;

            return row.getLastCellNum();

        }

//    public int getCellRowNum(String sheetName,String colName,String cellValue){
//
//        for(int i=2;i<=getRowCount(sheetName);i++){
//            if(getCellData(sheetName,colName , i).equalsIgnoreCase(cellValue)){
//                return i;
//            }
//        }
//        return -1;
//
//    }
        //for write cell on the excel sheet
        public void writeExcel(String sheetName, String cellvalue, int row, int col) throws IOException {
            XSSFSheet sheet = workbook.getSheet(sheetName);
            sheet.getRow(row).createCell(col).setCellValue(cellvalue);
            fileOut = new FileOutputStream(path);
            workbook.write(fileOut);
            workbook.close();
            fileOut.close();
        }


    }


