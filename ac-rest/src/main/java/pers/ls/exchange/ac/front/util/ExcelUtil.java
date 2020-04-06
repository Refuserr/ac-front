package pers.ls.exchange.ac.front.util;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class ExcelUtil {

    public static<E> List<E> readExcel(InputStream is,Class c) throws IOException, IllegalAccessException, InstantiationException {
        Field[] declaredFields = c.getDeclaredFields();
        List<Entity> entities = new ArrayList<>();
        for (Field field:declaredFields){
            boolean annotationPresent = field.isAnnotationPresent(Excel.class);
            if(annotationPresent){
                Excel annotation = field.getAnnotation(Excel.class);
                int sort = annotation.sort();
                entities.add(new Entity(field,sort));
            }
        }
        List<Entity> collect = entities.stream().sorted().collect(Collectors.toList());
        List datas = new ArrayList();
        //
        Workbook wb = WorkbookFactory.create(is);
        Sheet sheetAt = wb.getSheetAt(0);
        int lastRowNum = sheetAt.getLastRowNum();
        for(int i=1;i<lastRowNum+1;i++){
            Row row = sheetAt.getRow(i);
            Object o = c.newInstance();
            for(int j=0;j<collect.size();j++){
                Field field = collect.get(j).getField();
                Class<?> type = field.getType();
                field.setAccessible(true);
                Object value=null;
                if(type==String.class){
                     value = row.getCell(j).getStringCellValue();
                }
                if(type==int.class){
                    value = (int)row.getCell(j).getNumericCellValue();
                }
                if(type==short.class){
                    value = (short)row.getCell(j).getNumericCellValue();
                }
                if(type==byte.class){
                    value = (byte)row.getCell(j).getNumericCellValue();
                }
                if(type==float.class){
                    value = (float)row.getCell(j).getNumericCellValue();
                }
                if(type==boolean.class||type==Boolean.class){
                    value = row.getCell(j).getBooleanCellValue();
                }
                if(type== Date.class){
                    value = row.getCell(j).getDateCellValue();
                }
                field.set(o,value);
            }
            //添加转化后的数据
            datas.add(o);
        }
        return datas;
    }

    private static class Entity implements Comparable{
        private Field field;
        private  int sort;

        public Entity() {
        }

        public Entity(Field field, int sort) {
            this.field = field;
            this.sort = sort;
        }

        public Field getField() {
            return field;
        }

        public void setField(Field field) {
            this.field = field;
        }

        public int getSort() {
            return sort;
        }

        public void setSort(int sort) {
            this.sort = sort;
        }

        @Override
        public int compareTo(Object o) {
            Entity entity = (Entity)o;
            return sort-entity.getSort();
        }
    }

//text git test
    //git test
    public static void main(String[] args){
        List<Entity> e = Arrays.asList(new Entity(null,3),new Entity(null,1));
        List<Entity> collect = e.stream().sorted().collect(Collectors.toList());
        collect.forEach(e1->{
            System.out.println(e1.getSort());
        });
    }
}
