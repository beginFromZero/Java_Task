# Java_Task
java task

[Content Description]

project: Training_Java

package: 
    task_1:

        一、创建方法getRandomNums(),返回随机整型数组，数组大小由外部输入。
        提示：
            1、定义一个带参带返回值的方法，通过参数传入数组的长度，返回值为赋值后的数组
            2、创建指定长度的整型数组
            3、使用for循环遍历数组，通过Math.random()生成随机并给数组成员赋值
            4、使用return返回赋值后的数组
        二、定义一个包含整型数组参数的方法，用来接收整型数组，对数组进行排序并输出最大值前三名
        提示：
            1、在方法中使用Arrays类的sort()方法对数组进行排序，默认按升序排列，注意Arrays类的使用需要导入java.util.Arrays
            2、使用for循环遍历数组中的元素，由于要输出的是前三名，所以从后往前遍历，即倒序遍历如for(inti=scores.length-1;i>=0;i--){}
            3、小于60或大于100，则使用continue忽略
        三、完成main方法
            1、打印出数组内容
            2、显示前三名
            3、打印出最小值，和，平均值

    task_2:

        请尝试编写一个控制台版的小程序，名叫“租车系统”
        基本功能：
            1.展示所有可租车辆
            2.选择车型，租车量
            3.展示租车清单，包含总金额，总载货量系车型，总载人量及车型
                                                        
        提示：  
            创建1个父类Vehicle，3个子类Truck，Passengercar，Pickup，
            属性：CarModel，Price, VolumeOfCargo, NumOfPassenger
            定义打印全部属性的接口并实现，租车信息列表用【对象列表】实现，存储不同类的汽车对象
            在测试类实现总金额和总载量的计算方法。
            具体请参照慕课网上JAVA第二季第六章项目实战的内容。