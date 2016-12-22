# android-navi-fragment
fragement方式导航示例
## 前述 ##
- [高德官网申请Key](http://lbs.amap.com/dev/#/).
- 阅读[地图参考手册](http://a.amap.com/lbs/static/unzip/Android_Map_Doc/index.html).
- 阅读[导航参考手册](http://a.amap.com/lbs/static/unzip/Android_Navi_Doc/index.html).
- [科大讯飞开放平台申请Appid](http://www.xfyun.cn/services/online_tts).
- 工程基于Android 导航 SDK、科大讯飞在线语音合成SDK实现

## 使用方法##
###1:配置搭建AndroidSDK工程###
- [Android Studio工程搭建方法](http://lbs.amap.com/api/android-sdk/guide/creat-project/android-studio-creat-project/#add-jars).
- [通过maven库引入SDK方法](http://lbsbbs.amap.com/forum.php?mod=viewthread&tid=18786).

## 扫一扫安装##

 ![Screenshot](https://github.com/amap-demo/android-navi-fragement/blob/master/resource/download.png?raw=true)

## 结果展示##

 ![Screenshot](https://github.com/amap-demo/android-navi-fragement/blob/master/resource/screenshot.png?raw=true)
 
## 核心类/接口 ##
| 类    | 接口  | 说明   | 版本  |
| -----|:-----:|:-----:|:-----:|
|AMapNaviView|onCreate(Bundle bundle)|与Activity onCreate同步||
|AMapNaviView|onResume()|与Activity onResume同步||
|AMapNaviView|onPause()|与Activity onPause同步||
|AMapNaviView|onDestroy()|与Activity onDestroy同步在1.6.0之前，此方法会自动执行AMapNavi.stopNavi(); 在1.6.0之后（包括1.6.0），请用户自己根据需要选择执行AMapNavi.stopNavi()||

## 核心难点##
```java
      /**
     * 初始化AMapNaviView
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_navi, container, false);
        mAMapNaviView = (AMapNaviView) view.findViewById(R.id.navi_view);
        mAMapNaviView.onCreate(savedInstanceState);
        mAMapNaviView.setAMapNaviViewListener(this);
        return view;
    }
    
    
        /**
     * 驾车路径规划计算,返回单条路径
     */
    private void calculateDriveRoute() {
        try {
            strategyFlag = mAMapNavi.strategyConvert(true, false, false, true, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        mAMapNavi.calculateDriveRoute(startList, endList, wayList, strategyFlag);
    }
```
