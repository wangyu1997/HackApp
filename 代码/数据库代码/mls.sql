/*
 Navicat Premium Data Transfer

 Source Server         : docker_mysql
 Source Server Type    : MySQL
 Source Server Version : 50720
 Source Host           : 10.13.119.149:9999
 Source Schema         : mls

 Target Server Type    : MySQL
 Target Server Version : 50720
 File Encoding         : 65001

 Date: 14/04/2018 17:39:21
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for hibernate_sequence
-- ----------------------------
DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of hibernate_sequence
-- ----------------------------
BEGIN;
INSERT INTO `hibernate_sequence` VALUES (1);
COMMIT;

-- ----------------------------
-- Table structure for pic_model
-- ----------------------------
DROP TABLE IF EXISTS `pic_model`;
CREATE TABLE `pic_model` (
  `id` bigint(20) NOT NULL,
  `content` varchar(510) COLLATE utf8mb4_bin DEFAULT NULL,
  `img_url` varchar(510) COLLATE utf8mb4_bin DEFAULT NULL,
  `title` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of pic_model
-- ----------------------------
BEGIN;
INSERT INTO `pic_model` VALUES (1, '这是一个盲点幻觉，先闭上你的右眼找出你的盲点，同时用左眼看着小黑十字架，移动这幅图使它离你越来越近，直到百色圆点消失那么完整的十字架看起来象什么?很多人都会看到竖直的条在水平的条的前方', 'http://oq5d32gij.bkt.clouddn.com/1.jpg', '盲点幻觉');
INSERT INTO `pic_model` VALUES (2, '如果你看见这个舞女是顺时针转，说明你用的是右脑；如果是逆时针转，说明你用的左脑，耶鲁大学耗时5年的研究成果，据说，14%的美国人可以两个方向都能看见。', 'http://oq5d32gij.bkt.clouddn.com/2.gif', '一张图分出你是用左脑还是右脑');
INSERT INTO `pic_model` VALUES (3, '这是一个舞蹈者，他的手放在鞋里了，他的头被挡在一个胳膊后面。尽管这个客体的四肢很容易辨认出来，艺术家们有意让客体呈现出有悖于我们正常视觉体验的全面的外形轮廓，因此，你的知觉系统，当第一次看到这种画面，会费尽心思把我们所熟悉的四肢与一个合理而有趣的解释联系在一起。看着照片中的客体一会儿，你试着练习一下解决视觉问题的训练，那么整个画面就显得更有趣，而不那么离奇荒诞了。', 'http://oq5d32gij.bkt.clouddn.com/3.jpg', '这是什么');
INSERT INTO `pic_model` VALUES (4, '在这幅未经改动的照片中，伯德约翰逊夫人的头属于哪个身体?头是和右边身子相连的。这张照片是从一个非常特殊的角度拍摄的，因为只有一个头能看得见而且看起来是和两个不同的身子相连。所以会产生这种幻觉。人类的视力经常会设想我们并没有看到那些偶然产生非真实知觉的客体。这种假想叫做\"一般观点\"原则。一些女士看起来比男士在指认头的正确位置方面要好得多，这是因为她们根据服装线索。但是，我们依然毫无理由相信男士和女士之间的潜在视觉/知觉系统有区别。', 'http://oq5d32gij.bkt.clouddn.com/4.jpg', '双体女士');
INSERT INTO `pic_model` VALUES (5, '你能以多块的速度认出这张照片中的政治家?仔细再看一遍，你可能大吃一惊!仔细看画中人，你会发现这不是前总统比尔·克林顿与副总统艾尔·戈尔。尽管克林顿被正常地置于背景前方，背景人物依然是克林顿的脸。但有着艾尔·戈尔的头发与黑色西服，这表明前因后果在人形成画面的视觉效果方面起着多么重要的作用，而且不经意漏掉的细节却是多么重要。此外，发型和额头的宽度也是面部辨认的重要线索。对于非常熟悉戈尔和克林顿的人来说，这种幻觉最容易发生。麻省理工学院的视力科学家帕瓦·辛哈创作了本图。', 'http://oq5d32gij.bkt.clouddn.com/5.jpg', '总统幻觉');
INSERT INTO `pic_model` VALUES (6, '至少有两个组成部分来决定我们凝视的方向，第一个是眼睛瞳仁的位置，第二个是头部所指的方向，一般情况下我们会把这两种来源结合起来确定凝视的方向。这种情况下，我们就会产生一种幻觉，因为右边镜中成的像--除了眼睛没变--产生了左边的图像。这会引起她的凝视的方向的极大变化，哈佛视力科学家申基·安多创作了这幅蒙娜丽莎凝视幻觉图。WH华尔逊在1824年首先注意到这个效果。', 'http://oq5d32gij.bkt.clouddn.com/6.jpg', '哪一个蒙娜丽莎在望着你');
INSERT INTO `pic_model` VALUES (7, '如果从你座位前的电脑上看上面的图片，左边的图形是生气的脸而右边的图形是平静的脸，如果是这样，就好!请你起立往后走3~5步突然间他们交换位置了!!这个幻觉图片由Glasgow大学的PhillippeG.SchynsandAudeOliva所设计觉得有趣的话就顶一个吧', 'http://oq5d32gij.bkt.clouddn.com/7.jpg', '生气与平静');
INSERT INTO `pic_model` VALUES (8, '日本艺术家娜拉的面具游戏追溯到1192-1333时期，面部刻板的面具被认为是沉静、自制的，由于\"神奇\"的能力却可以改变表情。当你直视时，你可以看到一幅刻板严肃的面具，把它的面部表情和下两幅照片相比较，你会发现它面部表情的变化取决于面部的倾斜角度。面具的形状强调了某种特征，尤其是嘴的轮廓，视角的稍微变化都会改变嘴角到嘴唇的相对位置。我们的视觉系统对面部特征的细微变化都非常的敏感，这样就理解了面部不同的感情特征。', 'http://oq5d32gij.bkt.clouddn.com/8.jpg', '娜拉的神奇面具');
INSERT INTO `pic_model` VALUES (9, '这些房屋没有倒塌!他们座落在旧金山一条非常倾斜的街道上。摄影师倾斜了照相机以便于能和街道平行。而不是与真正的已被模糊化的地平线平行。我们试图拿一个参照结构来确定垂直或水平。在这种情况下，房屋结构被照片的长方形状装饰了，而这并没有真正的地平线相对应。水平线对视觉系统来说是一个非常重要的线索。因此，一条误导人的地平线，并不与地球重力成直角，也能产生各种幻觉。那个女士以那种看起来和街道垂直的方式增加这种幻觉。一般来说，她会和真正的水平垂直。', 'http://oq5d32gij.bkt.clouddn.com/9.jpg', '这些房屋怎么了');
INSERT INTO `pic_model` VALUES (10, '盯着玛丽林门罗的像看三十秒或三十秒以上，不要动。然后迅速朝一个硬的白色背景或灰色背景看。你将发现她的嘴唇是红色的……', 'http://oq5d32gij.bkt.clouddn.com/10.jpg', '玛丽林门罗余象');
INSERT INTO `pic_model` VALUES (11, '这个年轻人老了以后什么样儿?把图形倒过来就能找到答案', 'http://oq5d32gij.bkt.clouddn.com/11.jpg', '变老的错觉');
INSERT INTO `pic_model` VALUES (12, '盯着画像中心的蓝点，不要转移注意力，慢慢的蓝点就会褪去，这是填充幻觉。你的视觉系统只对一个画面内的变化有反应。一个不断变化的刺激物比一个静止的物体更重要。你的眼睛不停做出轻微的眼部运动，这样会帮助视觉画面不断发生变化而且可以被看见。蓝点逐渐溶进绿色，因为没有眼部系统的参照物来调整眼部运动，而且稳定状态的刺激物逐渐被忽略，几乎任何不产生变化的刺激物最终都会被忽略，不管它是一只紧紧的鞋子，一只过小的戒指还是你自己的心跳。疼痛神经末梢看起来相对来说不需适应，从而解释了长留的疼痛。此外，这幅幻觉中一个关键性的因素是基于这样一个事实：人类视力想尽力把色彩扩散到指定边界最近的亮处，既然在蓝和绿之间没有强光界限，绿就盖过了蓝。', 'http://oq5d32gij.bkt.clouddn.com/13.jpg', '填充物幻觉1');
INSERT INTO `pic_model` VALUES (13, '你看到的是紫色的还是白色的厨具', 'http://oq5d32gij.bkt.clouddn.com/14.jpg', '背景幻觉');
INSERT INTO `pic_model` VALUES (14, '这些是男士的腿，还是女士的腿?日本艺术家Shigeo Fukuda创作这幅插图。', 'http://oq5d32gij.bkt.clouddn.com/15.jpg', '两个不同性别的腿');
INSERT INTO `pic_model` VALUES (15, '你能发现藏在栏杆之间的人形吗？', 'http://oq5d32gij.bkt.clouddn.com/16.jpg', '令人心动的栏杆');
INSERT INTO `pic_model` VALUES (16, '你看见一堆黑色的东西吗？你看见了一个英文？', 'http://oq5d32gij.bkt.clouddn.com/17.gif', '字母在哪');
INSERT INTO `pic_model` VALUES (17, '奇妙的图形／背景幻觉图形，由斯坦福心理学家罗杰·谢泼德创作', 'http://oq5d32gij.bkt.clouddn.com/18.jpg', '节约时间的暗示');
INSERT INTO `pic_model` VALUES (18, '你看见六个杯子吗？还是看见六对不同态度的脸？', 'http://oq5d32gij.bkt.clouddn.com/19.gif', '杯子还是脸');
INSERT INTO `pic_model` VALUES (19, '你注意到花瓶的两边是脸了吗？', 'http://oq5d32gij.bkt.clouddn.com/20.jpg', '看到两张脸没有');
INSERT INTO `pic_model` VALUES (20, '这幅图形可能不可能?仔细看书架', 'http://oq5d32gij.bkt.clouddn.com/21.jpg', '不可能的书架');
INSERT INTO `pic_model` VALUES (21, '瑞典艺术家奥斯卡路透斯沃德创造的又一个奇思异想之物', 'http://oq5d32gij.bkt.clouddn.com/22.jpg', '不可能发生的怪事');
INSERT INTO `pic_model` VALUES (22, '你能数出几个分岔?把每个分岔的一半遮住，你将发现分岔另一半的端口都是完全成立的。但当你把揭开盖住的另一半，你又会得到一个完全不可能的图形。这幅图1964年开始出现于各种出版物中，没有人知道谁首先创造了这个著名的不可能图形', 'http://oq5d32gij.bkt.clouddn.com/23.jpg', '不可能的叉子');
INSERT INTO `pic_model` VALUES (23, '这是不可能的楼梯的物理模式。你能找到最高的和最底的台阶吗?从底下这幅图片看看这个模型是怎样做成的。', 'http://oq5d32gij.bkt.clouddn.com/24.jpg', '不可能的楼梯');
INSERT INTO `pic_model` VALUES (24, '比利时艺术家马瑟·黑梅克，从荷兰平面造型艺术家M.C.的一幅画中吸取灵感，创造了一个不可能存在的盒子的实物模型。', 'http://oq5d32gij.bkt.clouddn.com/25.jpg', '埃斯切尔的不可能的盒子');
INSERT INTO `pic_model` VALUES (25, '你知道直钢棒是怎样神奇地穿过这两个看似乎成直角的螺帽孔的吗', 'http://oq5d32gij.bkt.clouddn.com/26.jpg', '疯狂的螺帽');
INSERT INTO `pic_model` VALUES (26, '这是一个奇妙的不可能成立的曲折体，由匈牙利艺术家托马斯·伐克期创作', 'http://oq5d32gij.bkt.clouddn.com/27.jpg', '曲折的悖论');
INSERT INTO `pic_model` VALUES (27, '瑞典艺术家奥斯卡·卢特斯瓦尔德给了我们不可能的三角形中又一种变化', 'http://oq5d32gij.bkt.clouddn.com/28.jpg', '一个不可能的三角形中的不可能性');
INSERT INTO `pic_model` VALUES (28, '由麻省理工学院视力科学家泰德·安德森创作的这个图像中有两个幻觉。左边的楼梯看起来象堆积的木块；但右边的却象台阶，这是一种不可能的建筑.第二，有一个反射幻觉：左端的木块深浅颜色的部分和右边向下的台阶的灰色条纹是一样的颜色 ', 'http://oq5d32gij.bkt.clouddn.com/29.jpg', '反射错觉');
INSERT INTO `pic_model` VALUES (29, '眼睛是排列整齐的。圆圈对每一只眼睛是一个参照物，而你的意图是以参照物的顺序来判断秩序，既然圆圈打乱秩序，那么眼睛看起来也不齐。这种幻觉只是面部二维代表下的一种幻觉效果。', 'http://oq5d32gij.bkt.clouddn.com/30.jpg', '排错的眼睛');
INSERT INTO `pic_model` VALUES (30, '用勺子叉子和刀子组合投射出一辆摩托车的影子 ', 'http://oq5d32gij.bkt.clouddn.com/31.jpg', '摩托车的影子');
INSERT INTO `pic_model` VALUES (31, '其实一样,不过上前一步的变得瘦小，退后一步的变得高大', 'http://oq5d32gij.bkt.clouddn.com/32.jpg', '哪个更大？');
INSERT INTO `pic_model` VALUES (32, '前面、后面、前面、后面 ', 'http://oq5d32gij.bkt.clouddn.com/33.gif', '前面、后面、前面、后面 ');
INSERT INTO `pic_model` VALUES (33, '另一个维度的时空', 'http://oq5d32gij.bkt.clouddn.com/34.jpg', '哈利波特与迷失方向的楼梯');
INSERT INTO `pic_model` VALUES (34, '红色的表面是朝上还是朝下?一直盯着看：由于自相矛盾的深度线索它们会轻捷地转向另一个方向，这种模棱两可的图形是美国艺术家琼·米勒创作的。', 'http://oq5d32gij.bkt.clouddn.com/35.jpg', '错综复杂的图形');
INSERT INTO `pic_model` VALUES (35, '这幅图中包含许多幅荷兰图画大师伊瑟的多重镶嵌式肖像。伊瑟以创作镶嵌式图象而著名，把这幅画颠倒过来看效果仍然是一样的。美国艺术家肯·兰迪创作这幅图以示对伊琴的崇敬之心。', 'http://oq5d32gij.bkt.clouddn.com/36.jpg', '镶嵌格式的伊瑟');
INSERT INTO `pic_model` VALUES (36, '把整幅图旋转90度，你会发现其中的奥秘 ', 'http://oq5d32gij.bkt.clouddn.com/37.jpg', '巨像与人');
INSERT INTO `pic_model` VALUES (37, '瑞士艺术家桑德罗·戴尔·普里特创作这幅画，请注意两幅图形是怎样合成变形为一幅插图的?', 'http://oq5d32gij.bkt.clouddn.com/38.jpg', '挪玛德/游牧');
INSERT INTO `pic_model` VALUES (38, '两个内部的圆大小一样吗', 'http://oq5d32gij.bkt.clouddn.com/39.jpg', '埃冰斯幻觉');
INSERT INTO `pic_model` VALUES (39, '量量看，其实一样长', 'http://oq5d32gij.bkt.clouddn.com/40.gif', '线段AB长还是BC长？');
INSERT INTO `pic_model` VALUES (40, '这个正方形看起来变形了吗', 'http://oq5d32gij.bkt.clouddn.com/41.jpg', '奥毕森幻觉');
INSERT INTO `pic_model` VALUES (41, '黑线看起来是不是向外弯曲的 ', 'http://oq5d32gij.bkt.clouddn.com/42.jpg', '黑林图形');
INSERT INTO `pic_model` VALUES (42, '哪条线显得长一点，红线还是蓝线？', 'http://oq5d32gij.bkt.clouddn.com/43.jpg', '梯形幻觉');
INSERT INTO `pic_model` VALUES (43, '竖线似乎是弯曲的，但其实他们是笔直而相互平行的', 'http://oq5d32gij.bkt.clouddn.com/44.jpg', '曲线幻觉');
INSERT INTO `pic_model` VALUES (44, '答案是平行的', 'http://oq5d32gij.bkt.clouddn.com/45.jpg', '你能看出图中的横线是平行的吗？');
INSERT INTO `pic_model` VALUES (45, '圆圈缺口部分的两端能完整地接上吗', 'http://oq5d32gij.bkt.clouddn.com/46.jpg', '伯根道夫环形幻觉');
INSERT INTO `pic_model` VALUES (46, '答案是一样高', 'http://oq5d32gij.bkt.clouddn.com/47.gif', '这两个黑色的长方形哪个高？');
INSERT INTO `pic_model` VALUES (47, '哪条红线更长', 'http://oq5d32gij.bkt.clouddn.com/48.jpg', '米勒·莱尔幻觉');
INSERT INTO `pic_model` VALUES (48, '其实是一样长', 'http://oq5d32gij.bkt.clouddn.com/49.gif', '这两条竖线哪一条长？');
INSERT INTO `pic_model` VALUES (49, '它们实际上是平行的', 'http://oq5d32gij.bkt.clouddn.com/50.gif', '这两条线是弯曲的吗');
INSERT INTO `pic_model` VALUES (50, '图中的圆确实是一个正圆形', 'http://oq5d32gij.bkt.clouddn.com/51.gif', '是圆吗');
INSERT INTO `pic_model` VALUES (51, '线AB和线CD长度完全相等，虽然它们看起来相差很大 ', 'http://oq5d32gij.bkt.clouddn.com/52.jpg', '长度与透视');
INSERT INTO `pic_model` VALUES (52, '看立方体外侧面上的这个图形。哪条线与竖线垂直？哪条线不与竖线垂直？把立方体的边线遮住，你将发现你的感知发生了变化', 'http://oq5d32gij.bkt.clouddn.com/53.jpg', '盒子幻觉');
INSERT INTO `pic_model` VALUES (53, '安德森的蒙德里恩幻觉', 'http://oq5d32gij.bkt.clouddn.com/54.jpg', '安德森的蒙德里恩幻觉');
INSERT INTO `pic_model` VALUES (54, '所有的竖直线段都是一样长的吗？从头到尾所有的竖线都是同样的长度，我们应该注意到，看起来线条最长的部分，条块模型也是最密集的。是否这和产生出来的效果有关系，还有待考虑。', 'http://oq5d32gij.bkt.clouddn.com/55.jpg', '白天的赛因幻觉');
INSERT INTO `pic_model` VALUES (55, '这些是完全的正方形吗', 'http://oq5d32gij.bkt.clouddn.com/56.jpg', '曲线正方形');
INSERT INTO `pic_model` VALUES (56, '这些方格是不是看起来有点彼此倾斜', 'http://oq5d32gij.bkt.clouddn.com/57.jpg', '晃动的方格幻觉');
INSERT INTO `pic_model` VALUES (57, '这是一系列完好的同心圆。只是一个曲线幻觉的例子', 'http://oq5d32gij.bkt.clouddn.com/58.jpg', '扭曲的圆');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
