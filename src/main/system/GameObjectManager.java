package main.system;

import main.entity.GameObject;
import main.graphic.CcVector;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Objects;

public class GameObjectManager {

    public GameObject[] objectLibrary = new GameObject[100]; // 游戏物体类型库,通过下标来获取物品
    public LinkedList<GameObject> objectList = new LinkedList<>(); // 游戏对象集合

    public GamePanel gp;

    public GameObjectManager(GamePanel gp) {

        this.gp = gp;
        try {
            loadLibrary(); // 初始化物体类型
            loadGameObjectFromCsv("/objects/config/objectMap.csv"); // 创建游戏物体对象
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 绘制所有物体
     */
    public void draw(Graphics2D g2) {

        for (GameObject obj : objectList)
            obj.draw(g2);
    }



    /// -------------------------------- 预加载游戏物体模板 ---------------------------------------

    private void loadLibrary() throws IOException {

        setupObject(1, new CcVector(32, 32), "wall_stone.png");
        setupObject(2, new CcVector(32, 32), "platform.png");
        setupObject(3, new CcVector(32, 32), "spike_up.png");
        setupObject(4, new CcVector(24, 24), "basketball_0.png");
    }

    // 创建初始物体类型
    private void setupObject(int index, CcVector box, String imageName) throws IOException {

        GameObject object = new GameObject();
        object.pos = new CcVector(0, 0);
        object.box = box;
        object.img = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/objects/" + imageName)));
        objectLibrary[index] = object;
    }

    /// -------------------------------- 物体对象加载 ------------------------------------------
    /**
     * 从CSV表格中创建游戏物体
     * 物体库中标准物体浅拷贝而来，因此不能带事件和碰撞触发器
     */
    public void loadGameObjectFromCsv(String filePath) throws IOException {

        InputStream in = getClass().getResourceAsStream(filePath);
        if (in == null) // 找不到文件
            return;

        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        int col = 0, row = 0;
        while (row < gp.maxScreenRow) {

            String line = br.readLine();
            while (col < gp.maxScreenCol) {

                String[] arr = line.split(",");
                int num = Integer.parseInt(arr[col++]);
                if (num <= 0 || objectLibrary[num] == null)
                    continue;

                GameObject gameObject = objectLibrary[num].cloneObject();
                gameObject.pos = new CcVector((col-1) * gp.gridSize, (row) * gp.gridSize);
                objectList.add(gameObject);
            }

            col = 0; row++;
        }
        br.close();
    }

}
