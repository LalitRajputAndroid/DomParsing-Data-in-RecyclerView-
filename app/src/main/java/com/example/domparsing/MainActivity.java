package com.example.domparsing;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Document;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;



import java.io.InputStream;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class MainActivity extends AppCompatActivity {

    LinearLayout linearLayout;
    RecyclerView recyclerView;
    MyAdapter adapter;
    ArrayList<Modal> list =new ArrayList<>();
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayout = findViewById(R.id.linerlayout_id);
        recyclerView = findViewById(R.id.recyclerV_id);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        try {
            InputStream stream = getAssets().open("file.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document d = builder.parse(stream);
            Element element = d.getDocumentElement();
            element.normalize();

            NodeList nodeList = d.getElementsByTagName("student");
            for (int i=0;i<nodeList.getLength();i++){

                TextView t1 = new TextView(this);
                Node node = nodeList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE);{

                    Element element1 = (Element) node;

//                    t1.setTextSize(20);
//                    t1.setTextColor(Color.BLACK);
//                    t1.setText(t1.getText()+"Name : "+getValue("name",element1)+"\n");
//                    t1.setText(t1.getText()+"Roll No : "+getValue("rollno",element1)+"\n");
//                    t1.setText(t1.getText()+"Age : "+getValue("age",element1)+"\n");
//                    linearLayout.addView(t1);
                    Modal m = new Modal();
                    m.setName(getValue("name",element1));
                    m.setRoll_no(getValue("rollno",element1));
                    m.setAge(getValue("age",element1));
                    list.add(m);

                  adapter = new MyAdapter(list,context);
                  recyclerView.setAdapter(adapter);

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static String getValue(String tag,Element e){
        NodeList node = e.getElementsByTagName(tag).item(0).getChildNodes();
        Node nodes = node.item(0);
        return nodes.getNodeValue();

    }


}