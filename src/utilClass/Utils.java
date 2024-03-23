package utilClass;

import mainClass.Course;

import java.util.ArrayList;

public class Utils {
    // 设置控制台输出字体样式
    public static final String ANSI_RESET = "\u001B[0m"; // 重置所有属性
    public static final String ANSI_BLACK = "\u001B[30m"; // 黑色
    public static final String ANSI_RED = "\u001B[31m"; // 红色
    public static final String ANSI_GREEN = "\u001B[32m"; // 绿色
    public static final String ANSI_YELLOW = "\u001B[33m"; // 黄色
    public static final String ANSI_BLUE = "\u001B[34m"; // 蓝色
    public static final String ANSI_PURPLE = "\u001B[35m"; // 紫色
    public static final String ANSI_CYAN = "\u001B[36m"; // 青色
    public static final String ANSI_WHITE = "\u001B[37m"; // 白色

    public static final String ANSI_BOLD = "\u001B[1m"; // 粗体
    public static final String ANSI_UNDERLINE = "\u001B[4m"; // 下划线
    public static final String ANSI_BACKGROUND = "\u001B[40m"; // 背景色

    public static final String LAST_NAME =
            "赵 钱 孙 李 周 吴 郑 王 " +
            "冯 陈 褚 卫 蒋 沈 韩 杨 " +
            "朱 秦 尤 许 何 吕 施 张 " +
            "孔 曹 严 华 金 魏 陶 姜 " +
            "戚 谢 邹 喻 柏 水 窦 章 " +
            "云 苏 潘 葛 奚 范 彭 郎 " +
            "鲁 韦 昌 马 苗 凤 花 方 " +
            "俞 任 袁 柳 酆 鲍 史 唐 " +
            "费 廉 岑 薛 雷 贺 倪 汤 " +
            "滕 殷 罗 毕 郝 邬 安 常 " +
            "乐 于 时 傅 皮 卞 齐 康 " +
            "伍 余 元 卜 顾 孟 平 黄 " +
            "和 穆 萧 尹 姚 邵 湛 汪 " +
            "祁 毛 禹 狄 米 贝 明 臧 " +
            "计 伏 成 戴 谈 宋 茅 庞 " +
            "熊 纪 舒 屈 项 祝 董 梁 " +
            "杜 阮 蓝 闵 席 季 麻 强 " +
            "贾 路 娄 危 江 童 颜 郭 " +
            "梅 盛 林 刁 钟 徐 邱 骆 " +
            "高 夏 蔡 田 樊 胡 凌 霍 " +
            "虞 万 支 柯 昝 管 卢 莫 " +
            "经 房 裘 缪 干 解 应 宗 " +
            "丁 宣 贲 邓 郁 单 杭 洪 " +
            "包 诸 左 石 崔 吉 钮 龚 " +
            "程 嵇 邢 滑 裴 陆 荣 翁 " +
            "荀 羊 於 惠 甄 曲 家 封 " +
            "芮 羿 储 靳 汲 邴 糜 松 " +
            "井 段 富 巫 乌 焦 巴 弓 " +
            "牧 隗 山 谷 车 侯 宓 蓬 " +
            "全 郗 班 仰 秋 仲 伊 宫 " +
            "宁 仇 栾 暴 甘 钭 厉 戎 " +
            "祖 武 符 刘 景 詹 束 龙 " +
            "叶 幸 司 韶 郜 黎 蓟 薄 " +
            "印 宿 白 怀 蒲 邰 从 鄂 " +
            "索 咸 籍 赖 卓 蔺 屠 蒙 " +
            "池 乔 阴 郁 胥 能 苍 双 " +
            "闻 莘 党 翟 谭 贡 劳 逄 " +
            "温 别 庄 晏 柴 瞿 阎 充 " +
            "慕 连 茹 习 宦 艾 鱼 容 " +
            "向 古 易 慎 戈 廖 庾 终 " +
            "暨 居 衡 步 都 耿 满 弘 " +
            "匡 国 文 寇 广 禄 阙 东 " +
            "曾 毋 沙 乜 养 鞠 须 丰 " +
            "万俟 司马 上官 欧阳 " +
            "夏侯 诸葛 闻人 东方 " +
            "赫连 皇甫 尉迟 公羊 " +
            "澹台 公冶 宗政 濮阳 " +
            "淳于 单于 太叔 申屠 " +
            "公孙 仲孙 轩辕 令狐 " +
            "钟离 宇文 长孙 慕容 " +
            "鲜于 闾丘 司徒 司空";

    public static final String[] LAST_NAME_ARRAY = LAST_NAME.split("\\s+"); // 用于生成学生姓名

    public static final int LAST_NAME_ARRAY_LENGTH = LAST_NAME_ARRAY.length;

    // 男性名字
    public static final String FIRST_NAME_MALE = "靖涵\t远舟\t浩润\t依夫\t博弘\t杰洋\t禹朋\n" +
            "昊珂\t展舟\t韵辉\t泽杭\t彬元\t雨帆\t颂鸣\n" +
            "文正\t丰元\t弘熙\t翰华\t君宇\t依祥\t升安\n" +
            "晓琳\t德佑\t智远\t轩棋\t彬尚\t展畅\t兆栋\n" +
            "沐霖\t世星\t俊绍\t晋哲\t泽辉\t浩哲\t家庆\n" +
            "延政\t彬泰\t棋文\t泽城\t智月\t宇灿\t彪尊\n" +
            "依林\t翰辰\t旭泽\t清乾\t圣恒\t涛博\t宗杰\n" +
            "启宸\t柯依\t哲舟\t健瀚\t韶华\t棋胜\t晨杭\n" +
            "天淇\t知国\t弘琪\t弘桦\t荣庭\t涛文\t顺楠\n" +
            "志毅\t寒云\t至海\t秀楷\t君谦\t瀚辰\t政骏\n" +
            "依蓓\t君冠\t庸玉\t弘羽\t星磊\t昌德\t亚亮\n" +
            "忆夏\t风宇\t君翔\t棋帆\t浩天\t瀚帆\t锋启\n" +
            "博振\t浩璋\t博若\t宇帆\t韵磊\t温谨\t龙升\n" +
            "佳妍\t志鹤\t弘恒\t泽韶\t宇鹤\t江潮\t亦升\n" +
            "越叶\t若溪\t博均\t晋新\t博亦\t苑涛\t乐彬\n" +
            "璐瑶\t强恒\t文鹤\t智翎\t弘元\t昊柏\t经辰\n" +
            "宜涵\t旭豪\t浩修\t青林\t寒霖\t昌耀\t源奕\n" +
            "亦欣\t宇栋\t轩峻\t鸿润\t昌信\t翰轩\t天迅\n" +
            "泽俊\t昌国\t知彰\t弘易\t博恩\t棋苑\t信坤\n" +
            "琬琰\t弘瑜\t文德\t柯仁\t远辰\t全智\t霖健\n" +
            "奕恺\t德欢\t文义\t尚兴\t依振\t鼎茂\t迅茂\n" +
            "宜宏\t辉轩\t圣伯\t弘泰\t文庭\t万松\t祥衡\n" +
            "楚阳\t远丰\t睿圣\t常柯\t棋天\t棕德\t曦咏\n" +
            "灵芯\t天佑\t泰运\t维新\t志朋\t彤逸\t仲信\n" +
            "宏仪\t荣茂\t泰恒\t彬逸\t达鸣\t宇承\t清磊\n" +
            "远哲\t圣瀚\t文方\t鸿颜\t圣德\t世翰\t家林\n" +
            "嘉乐\t宇尚\t晋辰\t晋拓\t翰瑞\t涛瀚\t宽经\n" +
            "浩轩\t瀚景\t昌辉\t天鸣\t明耀\t博远\t鑫亦\n" +
            "意隆\t文峻\t涛影\t博奇\t昌智\t瀚东\t品江\n" +
            "毅宸\t韵皓\t翰宇\t浩龙\t智新\t翰尚\t辰卫\n" +
            "璟妍\t展轩\t辉宇\t德信\t杰融\t文盛\t龙龙\n" +
            "睿淇\t弥茂\t俊桦\t文楷\t圣龙\t君遥\t江佑\n" +
            "译星\t圣琪\t俊翰\t文林\t圣楠\t月华\t嘉浚\n" +
            "智轩\t光辉\t旭柏\t博仁\t致波\t晓奇\t永浚\n" +
            "正阳\t仁顺\t哲伦\t明楷\t志伟\t文博\t信永\n" +
            "嘉佑\t旭哲\t博帆\t寒远\t博昌\t博皓\t明震\n" +
            "咏笑\t远达\t文青\t志材\t彤玮\t博辰\t祖奕\n" +
            "懿桐\t智城\t鼎辉\t文语\t远松\t云新\t奕兴\n" +
            "柯洁\t晏逸\t龙赫\t宏烁\t朋良\t庆浩\t松建\n" +
            "铭煊\t成源\t侨秋\t世秋\t钧汉\t亮锡\t浩玮\n" +
            "萧彬\t同彦\t伟伟\t渝世\t渝辰\t纶霖\t廷俊\n" +
            "润梦\t成祖\t儒磊\t毅秦\t凯杉\t云磊\t尊榕\n" +
            "筱桐\t辰栋\t航鸣\t聪家\t洋威\t乐毅\t磊田\n" +
            "宇瀚\t雄浩\t兴正\t浩海\t启杭\t坤宗\t源勤";

    public static final String[]FIRST_NAME_MALE_ARRAY = FIRST_NAME_MALE.split("\\t|\\n"); // 用于生成学生姓名

    public static final int FIRST_NAME_MALE_ARRAY_LENGTH = FIRST_NAME_MALE_ARRAY.length;

    // 女性名字
    public static final String FIRST_NAME_FEMALE = "梦琪\t忆柳\t之桃\t慕青\t问兰\t元香\t初夏\t沛菡\t傲珊\t曼文\t乐菱\t痴珊\t恨玉\t惜文\n" +
            "香寒\t新柔\t语蓉\t海安\t夜蓉\t涵柏\t水桃\t醉蓝\t春儿\t语琴\t从彤\t傲晴\t语兰\t又菱\n" +
            "碧彤\t元霜\t怜梦\t紫寒\t妙彤\t曼易\t南莲\t紫翠\t雨寒\t易烟\t如萱\t若南\t寻真\t晓亦\n" +
            "向珊\t慕灵\t以蕊\t寻雁\t映易\t雪柳\t孤岚\t笑霜\t海云\t凝天\t沛珊\t寒云\t冰旋\t宛儿\n" +
            "绿真\t盼儿\t晓霜\t碧凡\t夏菡\t曼香\t若烟\t半梦\t雅绿\t冰蓝\t灵槐\t平安\t书翠\t翠风\n" +
            "香巧\t代云\t梦曼\t幼翠\t友巧\t听寒\t梦柏\t醉易\t访旋\t亦玉\t凌萱\t访卉\t怀亦\t笑蓝\n" +
            "春翠\t靖柏\t夜蕾\t冰夏\t梦松\t书雪\t乐枫\t念薇\t靖雁\t寻春\t恨山\t从寒\t忆香\t觅波\n" +
            "静曼\t凡旋\t以亦\t念露\t芷蕾\t千兰\t新波\t代真\t新蕾\t雁玉\t冷卉\t紫山\t千琴\t恨天\n" +
            "傲芙\t盼山\t怀蝶\t冰兰\t山柏\t翠萱\t恨松\t问旋\t从南\t白易\t问筠\t如霜\t半芹\t丹珍\n" +
            "冰彤\t亦寒\t寒雁\t怜云\t寻文\t乐丹\t翠柔\t谷山\t之瑶\t冰露\t尔珍\t谷雪\t乐萱\t涵菡\n" +
            "海莲\t傲蕾\t青槐\t冬儿\t易梦\t惜雪\t宛海\t之柔\t夏青\t亦瑶\t妙菡\t春竹\t痴梦\t紫蓝\n" +
            "晓巧\t幻柏\t元风\t冰枫\t访蕊\t南春\t芷蕊\t凡蕾\t凡柔\t安蕾\t天荷\t含玉\t书兰\t雅琴\n" +
            "书瑶\t春雁\t从安\t夏槐\t念芹\t怀萍\t代曼\t幻珊\t谷丝\t秋翠\t白晴\t海露\t代荷\t含玉\n" +
            "书蕾\t听白\t访琴\t灵雁\t秋春\t雪青\t乐瑶\t含烟\t涵双\t平蝶\t雅蕊\t傲之\t灵薇\t绿春\n" +
            "含蕾\t从梦\t从蓉\t听兰\t听蓉\t语芙\t夏彤\t凌瑶\t忆翠\t幻灵\t怜菡\t紫南\t依珊\t初丹\n" +
            "妙竹\t访烟\t怜蕾\t映寒\t友绿\t冰萍\t惜霜\t凌香\t芷蕾\t雁卉\t迎梦\t元柏\t代萱\t紫真\n" +
            "千青\t凌寒\t紫安\t寒安\t怀蕊\t秋荷\t涵雁\t以山\t凡梅\t盼曼\t翠彤\t谷冬\t新巧\t冷安\n" +
            "千萍\t冰烟\t雅阳\t友绿\t南松\t诗云\t飞风\t寄灵\t书芹\t幼蓉\t以蓝\t笑寒\t忆寒\t秋烟\n" +
            "芷巧\t水香\t映之\t醉波\t幻莲\t夜山\t芷卉\t向彤\t小玉\t幼南\t凡梦\t尔曼\t念波\t迎松\n" +
            "青寒\t笑天\t涵蕾\t碧菡\t映秋\t盼烟\t忆山\t以寒\t寒香\t小凡\t代亦\t梦露\t映波\t友蕊\n" +
            "寄凡\t怜蕾\t雁枫\t水绿\t曼荷\t笑珊\t寒珊\t谷南\t慕儿\t夏岚\t友儿\t小萱\t紫青\t妙菱\n" +
            "冬寒\t曼柔\t语蝶\t青筠\t夜安\t觅海\t问安\t晓槐\t雅山\t访云\t翠容\t寒凡\t晓绿\t以菱\n" +
            "冬云\t含玉\t访枫\t含卉\t夜白\t冷安\t灵竹\t醉薇\t元珊\t幻波\t盼夏\t元瑶\t迎曼\t水云\n" +
            "访琴\t谷波\t乐之\t笑白\t之山\t妙海\t紫霜\t平夏\t凌旋\t孤丝\t怜寒\t向萍\t凡松\t青丝";

    public static final String[]FIRST_NAME_FEMALE_ARRAY = FIRST_NAME_FEMALE.split("\\t|\\n"); // 用于生成学生姓名

    public static final int FIRST_NAME_FEMALE_ARRAY_LENGTH = FIRST_NAME_FEMALE_ARRAY.length;

/*
    public static final String[] COURSE_NAME = {"高等数学", "线性代数", "概率与数理统计", "离散数学", "计算机科学导论", "程序设计", "汇编语言",
                                                "计算机组成原理", "算法与数据结构", "操作系统原理", "软件工程", "计算机网络与通信", "编译原理", "数据库系统原理"};
*/

    public static final Course[] COURSES = { // 记录课程信息
            new Course("MATH101", "高等数学", 4),
            new Course("MATH201", "线性代数", 3),
            new Course("STAT301", "概率与数理统计", 3),
            new Course("MATH301", "离散数学", 3),
            new Course("CS101", "计算机科学导论", 3),
            new Course("CS102", "程序设计", 4),
            new Course("CS202", "汇编语言", 3),
            new Course("CS301", "计算机组成原理", 4),
            new Course("CS302", "算法与数据结构", 4),
            new Course("CS401", "操作系统原理", 4),
            new Course("CS402", "软件工程", 4),
            new Course("CS501", "计算机网络与通信", 4),
            new Course("CS502", "编译原理", 3),
            new Course("CS601", "数据库系统原理", 4)
    };

    public static final String[] SEMESTERS = {"2019-2020-1", "2019-2020-2", "2020-2021-1", "2020-2021-2",
            "2021-2022-1", "2021-2022-2", "2022-2023-1", "2022-2023-2", "2023-2024-1", "2023-2024-2"};





}
