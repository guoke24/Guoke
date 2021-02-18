package com.guohao.guoke.kotlin.kaixue;

import android.app.Activity;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

// 泛型测试
class fanxing_test extends Activity {

    TextView textView = new Button(this);
    TextView[] textViews = new Button[10];
// 👆 这是多态

//  List<Button> buttons = new ArrayList<Button>();
//  List<TextView> textViews = buttons;
// 👆 多态用在这里会报错 incompatible types: List<Button> cannot be converted to List<TextView>
// Java 的泛型类型会在编译时发生类型擦除，为了保证类型安全，不允许这样赋值。

    //List<? extends TextView> textViews1 = new ArrayList<View>(); // 会报错
    List<? extends TextView> textViews2 = new ArrayList<TextView>();
    List<? extends TextView> textViews3 = new ArrayList<Button>(); // 直接子类
    List<? extends TextView> textViews4 = new ArrayList<RadioButton>(); // 间接子类
    // ? extends 叫做「上界通配符」，可以使 Java 泛型具有「协变性 Covariance」

    {
        TextView textView = textViews3.get(0);
        // get 到的一定是 TextView 的子类

//        textViews3.add(new RadioButton(this));
//        textViews3.add(new Button(this));
//        textViews3.add(new TextView(this));
//        textViews3.add(new View(this));
        // 👆 add 会报错，no suitable method found for add(TextView)
        // 上界通配符 ? extends 的泛型 List，，只能够向外提供数据被消费
        // ? extends Button 对于 add 函数意味着，无论传 Button 还是 RadioButton，都没能转为一个固定的类型
        // ? extends Button 对于 get 函数意味着，无论拿到 Button 还是 TextView，都能转为 TextView 这一个固定的类型
        // 只能 get 操作，out 的感觉
    }

    List<? super Button> buttons2 = new ArrayList<Button>();// 👈 本身
    List<? super Button> buttons3 = new ArrayList<TextView>();// 👈 直接父类
    List<? super Button> buttons4 = new ArrayList<Object>();// 👈 间接父类

    {
        //Button button = buttons3.get(0);  // 报错

        buttons3.add(new RadioButton(this));
        buttons3.add(new Button(this));
        //buttons3.add(new TextView(this)); // 报错
        //buttons3.add(new View(this));     // 报错
        // 下界通配符 ? super 的泛型 List，只能读取到 Object 对象，
        // ? super Button 对于 add 函数意味着，无论传 Button 还是 RadioButton，都能转为 Button 这一个固定的类型
        // ? super Button 对于 get 函数意味着，无论拿到 Button 还是 TextView，都没能转为一个固定的类型
        // 只能 add 操作，in 的感觉

    }

    // 小结下，Java 的泛型本身是不支持协变和逆变的。
    //
    // 可以使用泛型通配符 ? extends 来使泛型支持协变，但是「只能读取不能修改」，这里的修改仅指对泛型集合添加元素，如果是 remove(int index) 以及 clear 当然是可以的。
    // 可以使用泛型通配符 ? super 来使泛型支持逆变，但是「只能修改不能读取」，这里说的不能读取是指不能按照泛型类型读取，你如果按照 Object 读出来再强转当然也是可以的。
    // 根据前面的说法，这被称为 PECS 法则：「Producer-Extends, Consumer-Super」。

    // kotlin
    // 使用关键字 out 来支持协变，等同于 Java 中的上界通配符 ? extends。
    // 使用关键字 in 来支持逆变，等同于 Java 中的下界通配符 ? super。

}
