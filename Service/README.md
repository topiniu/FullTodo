# 说明：  
## 1 映射路径：  
1. _`/names`_  
   获取用所有户名的映射路径
2. _`/todolist`_  
   获取待办事项的映射路径  
3. _`/adduser`_  
   添加用户的映射路径  
4. _`/addtodolist`_  
   添加待办事项的映射路径

## 2 类：
1. **IOTools**  
   -- 参数：  
   1.`PATH` : 数据保持路径，其中一个 `username.json` 文件和一个保存所有用户待办事项文件的 Todo List 文件夹  
   2.`TODOLIST` : 保存所有用户待办事项文件的文件夹  

2. **addTodoList**  
   添加 / 修改 / 覆盖某用户的待办事项    
   -- POST 传参：  
   json对象 :   
   ```
   {
       name:"name",
       todoList: ` {  // 特别注意这里的值是字符串形式的 JSON 对象!!!
            "2017-08-02":[
                    {
                        "content":"test",
                        "data":"2017-08-02",
                        "isFinished":false
                    },
                    {
                        "content":"test",
                        "data":"2017-08-02",
                        "isFinished":false
                    },
                    // ......
            ]
        } `
   } 
   ```  
   `name` : 根据 `name` 来添加 / 修改 / 覆盖相应的待办事项。  
   `todoList` : 根据传的参数 `name` 保存在相应的待办事项数据文件里，**__特 别 注 意 这 里 的 值 是 字 符 串 形 式 的 JSON 对 象 !!!__**  
   
3. **addUser**  
   添加用户名  
   -- POST 传参 :   
   `names` : 用户名列表  
   例如：  
   ```
   {
       name:"['Frank','name1','name2']"  // 特别注意这里的值是字符串形式的 JSON 对象!!!
   }
   ```  

4. **getTodoList**  
   获取待办事项，json 格式  
   -- 参数 ：  
   `name` : 根据 `name` 来获取相应的待办事项，例如：  
   ```
   var map = {
        name :'Frank',
    };
   ```
   -- 返回数据 :  
   根据传的name获取相应的待办事项  
   
5. **getUsername**  
   获取已注册的用户名列表  
   -- 返回数据 :   
   数组，例如：`["Frank","name1","name2"]`  

## 3 详细的传数据和取数据的例子：  
1. 获取用户名列表：
```
$("#names").on("click",function(){
    url = "http://127.0.0.1:8080/names",
    $.post(url,function(data) {
        console.log(data);
    });
})
```  
2.  获取某用户的待办事项
```
$("#todolist").on("click",function(){
    var map = {
        name :'Frank',
    };
    url = "http://127.0.0.1:8080/todolist",
    $.post(url, map,function(data) {
        console.log(data);
    });
})
```  
3.  添加用户列表
```
$("#adduser").on("click",function(){
    var map = {
        names :'["name1123213","name112323","name1123213","name1123","name2123"]',
    };
    url = "http://127.0.0.1:8080/adduser",
    $.post(url, map , function(data) {
        console.log(data);
    });
})
```  
4. 添加某用户的待办事项数据
```
var jsonData = 
`{ //字符串
    "2017-08-02":[
        {
            "content":"test",
            "data":"2017-08-02",
            "isFinished":false
        },
        {
            "content":"test",
            "data":"2017-08-02",
            "isFinished":false
        },
    ]
}`

$("#addtodolist").on("click",function(){
    var map = {
        name :'ching',
        todoList:jsonData,
    };
    url = "http://127.0.0.1:8080/addtodolist",
    $.post(url, map , function(data) {
        console.log(data);
    });
})
```

