package FullTodo;

import javax.servlet.http.HttpServletRequest;
import java.io.*;

// 相关的IO操作
// 参数:
// 1.PATH:
//   数据保持路径，其中一个 username.json 文件和一个保存所有用户待办事项文件的 Todo List 文件夹
// 2.TODOLIST:
//   保存所有用户待办事项文件的文件夹
public class IOTools {
    static final String PATH = "C:\\Users\\Frank\\Desktop\\1\\Json Data\\";
    static final String TODOLIST = "Todo List\\";

    public static String getUsername(){
        File file = new File(PATH + "username.json");
        String content = getData(file);
        return content;
    }

    public static void addUser(String names){
        File file = new File(PATH + "username.json");
        addData(file,names);
    }

    public static String getTodoList(String username){
        File file = new File(PATH + TODOLIST + username + ".json");
        String content = getData(file);
        return content;
    }

    public static void addTodoList(String username,String todolist){
        File file = new File(PATH + TODOLIST + username + ".json");
        addData(file,todolist);
    }

    public static String getData(File file){
        String content = "";
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            String line = null;
            while((line = bufferedReader.readLine()) != null){
                content = content + new String(line.getBytes(),"UTF-8") + "\n";
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (bufferedReader != null){
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return content;
    }

    public static void addData(File file,String listOrNames){
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file),"UTF-8"));
            bufferedWriter.write(listOrNames);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedWriter != null) {
                    bufferedWriter.flush();
                    bufferedWriter.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static String readJSONString(HttpServletRequest request){
        StringBuffer json = new StringBuffer();
        String line = null;
        try {
            BufferedReader reader = request.getReader();
            while((line = reader.readLine()) != null) {
                json.append(line);
            }
        }
        catch(Exception e) {
            System.out.println(e.toString());
        }
        return json.toString();
    }

}
