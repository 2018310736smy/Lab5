package gushi;

import java.io.*;
import java.util.Scanner;

public class monizuoye {


    /**
     * 读取txt文件的内容
     * @param file 想要读取的文件对象
     * @return 返回文件内容
     */
    public static String txt2String(File file){


        String result="";
        try {
            String encoding = "GBK"; // 字符编码(可解决中文乱码问题 )
            if (file.isFile() && file.exists()) {
                                InputStreamReader read = new InputStreamReader(
                                               new FileInputStream(file), encoding);
                                BufferedReader bufferedReader = new BufferedReader(read);
                              String lineTXT = null;
                               while ((lineTXT = bufferedReader.readLine()) != null) {
                                   result =result + lineTXT.toString().trim();
                                  }
                             read.close();
                           }else{
                               System.out.println("找不到指定的文件！");
                          }
                  } catch (Exception e) {
                       System.out.println("读取文件内容操作出错");
                       e.printStackTrace();
        }
        return result.toString();
    }

    /**
     * 保存str到指定路径下
     * @param path
     * @param str
     */
    public static void saveString(String path,String str){
        File fp=new File(path);
        try {
            PrintWriter pfp= new PrintWriter(fp);
            pfp.print(str);
            pfp.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static String addFh(String content){
        String result = "";

        int i=1;
        char[]  chars = content.toCharArray();
        for(char hz:chars){
            result = result +hz;
            if(i%7==0&&i%14!=0){
                result = result +",";
            }
            if(i%14==0){
                result = result +".\n\r";
            }
            i++;
        }
        return result;
    }

    public static void searchStr(String str,String outputFileContent){
        //获取字符串的长度
        int strlen=outputFileContent.length();

        //把需要查找的元素都替换为空
        String afterstr=outputFileContent.replaceAll(str,"");

        //获取替换后的字符串的长度
        int afterlen=afterstr.length();

        //要被查找的元素的个数=原长度-替换后的长度
        int endlen=strlen-afterlen;

        System.out.println("字符"+str+"出现次数为："+endlen);
    }

    public static void main(String[] args) {


        Student student = new Student("1","张三","男");

        System.out.println("学生信息："+student.toString());

        File file = new File("D:/java/4/src/inputFileContent.txt");
        String inputFileContent = txt2String(file);

        System.out.println(inputFileContent);
        String outputFileContent =  outputFileContent = student.toString() + "\r\n" +addFh(inputFileContent);
        System.out.println(outputFileContent);

        //将学生信息和古诗保存在文件中



        saveString("D:/java/4/src/outFileContent.txt",outputFileContent);

        Scanner input=new Scanner(System.in);

        System.out.println("请输入需要搜索的文字：");
        String str=input.next();

        searchStr(str,inputFileContent);

    }





}

