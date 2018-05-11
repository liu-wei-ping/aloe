package com.aloe.utils;

import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.metadata.BaseRowModel;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.read.context.AnalysisContext;
import com.alibaba.excel.read.event.AnalysisEventListener;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.aloe.pojo.vo.demo.SalesLeadsImportInfo;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.apache.tomcat.util.file.ConfigFileLoader.getInputStream;

/**
 * @author liu_wp
 * @date Created in 2018/5/11 11:06
 * @see
 */
public class ExcelUtil {
    public static void noModelMultipleSheet(String file) {
        InputStream inputStream = null;
        try {
            inputStream = getInputStream(file);
            ExcelReader reader = new ExcelReader(inputStream, ExcelTypeEnum.XLSX, null,
                    new AnalysisEventListener<List<String>>() {
                        @Override
                        public void invoke(List<String> object, AnalysisContext context) {
                            System.out.println(
                                    "当前sheet:" + context.getCurrentSheet().getSheetNo() + " 当前行：" + context.getCurrentRowNum()
                                            + " data:" + object);
                        }

                        @Override
                        public void doAfterAllAnalysed(AnalysisContext context) {

                        }
                    });

            reader.read();
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
//        String file="E:\\线索导入数据\\通孚祥.xlsx";
        String file = "E:\\线索导入数据\\测试导入线索模板.xlsx";
//        noModelMultipleSheet(file);
        analysisExcelToObject(file, SalesLeadsImportInfo.class);
        String tmpDir = System.getProperty("java.io.tmpdir");
        System.out.println(tmpDir + File.separator + "easyexcel");
    }

    public static void analysisExcelToObject(String file, Class<? extends BaseRowModel> clazz) {
        InputStream inputStream = null;
        try {
            inputStream = getInputStream(file);
            // 解析每行结果在listener中处理
            AnalysisEventListener listener = new ExcelListener();
            ExcelReader excelReader = new ExcelReader(inputStream, ExcelTypeEnum.XLSX, null, listener);

            excelReader.read(new Sheet(1, 1, clazz));
        } catch (Exception e) {

        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}

/* 解析监听器，
 * 每解析一行会回调invoke()方法。
 * 整个excel解析结束会执行doAfterAllAnalysed()方法
 *
 * @author jipengfei
 * @date 2017/03/14
 */
class ExcelListener extends AnalysisEventListener {

    //自定义用于暂时存储data。
    //可以通过实例获取该值
    private List<Object> datas = new ArrayList<Object>();

    @Override
    public void invoke(Object object, AnalysisContext context) {
        System.out.println("当前行：" + context.getCurrentRowNum());
        System.out.println(object);
        datas.add(object);//数据存储到list，供批量处理，或后续自己业务逻辑处理。
        doSomething(object);//根据自己业务做处理
    }

    /**
     * @param object
     */
    private void doSomething(Object object) {
        //1、入库调用接口
        if (object != null) {
            SalesLeadsImportInfo salesLeadsImportInfo = (SalesLeadsImportInfo) object;
            System.out.println(salesLeadsImportInfo.getLeadCreateTime());
            System.out.println(salesLeadsImportInfo.getMobilePhone());
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        // datas.clear();//解析结束销毁不用的资源
    }

    public List<Object> getDatas() {
        return datas;
    }

    public void setDatas(List<Object> datas) {
        this.datas = datas;
    }
}