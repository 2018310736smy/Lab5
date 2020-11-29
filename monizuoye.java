package gushi;

import java.io.*;
import java.util.Scanner;

public class monizuoye {


    /**
     * ��ȡtxt�ļ�������
     * @param file ��Ҫ��ȡ���ļ�����
     * @return �����ļ�����
     */
    public static String txt2String(File file){


        String result="";
        try {
            String encoding = "GBK"; // �ַ�����(�ɽ�������������� )
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
                               System.out.println("�Ҳ���ָ�����ļ���");
                          }
                  } catch (Exception e) {
                       System.out.println("��ȡ�ļ����ݲ�������");
                       e.printStackTrace();
        }
        return result.toString();
    }

    /**
     * ����str��ָ��·����
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
        //��ȡ�ַ����ĳ���
        int strlen=outputFileContent.length();

        //����Ҫ���ҵ�Ԫ�ض��滻Ϊ��
        String afterstr=outputFileContent.replaceAll(str,"");

        //��ȡ�滻����ַ����ĳ���
        int afterlen=afterstr.length();

        //Ҫ�����ҵ�Ԫ�صĸ���=ԭ����-�滻��ĳ���
        int endlen=strlen-afterlen;

        System.out.println("�ַ�"+str+"���ִ���Ϊ��"+endlen);
    }

    public static void main(String[] args) {


        Student student = new Student("1","����","��");

        System.out.println("ѧ����Ϣ��"+student.toString());

        File file = new File("D:/java/4/src/inputFileContent.txt");
        String inputFileContent = txt2String(file);

        System.out.println(inputFileContent);
        String outputFileContent =  outputFileContent = student.toString() + "\r\n" +addFh(inputFileContent);
        System.out.println(outputFileContent);

        //��ѧ����Ϣ�͹�ʫ�������ļ���



        saveString("D:/java/4/src/outFileContent.txt",outputFileContent);

        Scanner input=new Scanner(System.in);

        System.out.println("��������Ҫ���������֣�");
        String str=input.next();

        searchStr(str,inputFileContent);

    }





}
