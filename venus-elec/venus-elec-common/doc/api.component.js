/**
 * 5.1	弹出选择控件数据结构
 */
let components = (function(){
     return
    ({
         title : "1#变压器",         //控件标题
         value : "m0233,32323",     //默认选择值
         labelName: "name",         //标签字段名称
         valueName: "indBNo",       //值标字段名称
         multiple : false,          //默认值单选,      //true多选,false单选
         dataType : "table",
         data     :
         [
             {
             	groupName : "电流",
             	items     : 
             	[
                   {
                   	  name     : "A相电流",
                   	  indBNo   : "01020001"
                   },
                    {
                   	  name     : "B相电流",
                   	  indBNo   : "01020002"
                   }
             	]
             }
         ]
     });
}());


