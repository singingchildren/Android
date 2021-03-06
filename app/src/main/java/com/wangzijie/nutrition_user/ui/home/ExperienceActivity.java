package com.wangzijie.nutrition_user.ui.home;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;
import com.wangzijie.nutrition_user.R;

public class ExperienceActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experience);


        ImageView image1 = findViewById(R.id.image1);
        ImageView image2 = findViewById(R.id.image2);
        ImageView image3 = findViewById(R.id.image3);
        ImageView image4 = findViewById(R.id.image4);
        ImageView image5 = findViewById(R.id.image5);
        ImageView image6 = findViewById(R.id.image6);
        ImageView image7 = findViewById(R.id.image7);


        TextView title = findViewById(R.id.title);
        TextView textconent = findViewById(R.id.textconent);
        title.setText("营养师工作室管理、示范、 激励文件");


        Glide.with(this)
                .load(R.drawable.experience3)
                .into(image1);
        Glide.with(this)
                .load(R.drawable.experience4)
                .into(image2);
        Glide.with(this)
                .load(R.drawable.experience5)
                .into(image3);
        Glide.with(this)
                .load(R.drawable.experience6)
                .into(image4);
        Glide.with(this)
                .load(R.drawable.experience7)
                .into(image5);
        Glide.with(this)
                .load(R.drawable.experience2)
                .into(image6);
        Glide.with(this)
                .load(R.drawable.experience1)
                .into(image7);

        textconent.setText(
                "英特智科字﹝2019﹞05 号 \n" +
                        " \n" +
                        " \n" +
                        "营养师工作室管理、示范、激励 \n" +
                        " \n" +
                        "一、定义和名称 \n" +
                        "（一）定义 \n" +
                        "营养师工作室是由一个或者多个人同时发起（平台只显示发起人\n" +
                        "和管理员），由营养师组成的服务客户健康管理的商业组织。 \n" +
                        "（二）名称 \n" +
                        "1、查重：工作室名称唯一 \n" +
                        "2、非城市连锁工作室：工作室名称 \n" +
                        "3、城市连锁工作室：城市名+工作室名称+字号名 \n" +
                        "二、优势 \n" +
                        "（一）品牌塑造：资源集中 \n" +
                        "（二）客户保障：客户认同 \n" +
                        "（三）业务优势：增加集团业务和政府业务 \n" +
                        "（四）分配灵活：平台标准分配和雇佣 \n" +
                        "三、组织管理 \n" +
                        "由发起营养师，符合国家法律、公共健康管理政策、营养师宣言、\n" +
                        "平台政策的情况下，根据协议规定，由工作室管理员统一进行组织管\n" +
                        "理。 \n" +
                        "四、工作室发起原则 \n" +
                        "（一）根据需求，可以申请一个以城市/区/县城为单位的工作室，以\n" +
                        "详细的地理位置在平台上进行注册。 \n" +
                        "（二）工作室必须配备管理员，一个人只能兼任一个工作室管理员，\n" +
                        "管理员由工作室营养师间选拔，连锁工作室管理员可以上下级管理。\n" +
                        " \n" +
                        "（三）十人以上的工作室，可以申请分工作室，可以城市向下发展和\n" +
                        "其他城市业务工作室活动。 \n" +
                        "（四）工作室级别和数量以及申请条件 \n" +
                        "1、城市工作室     1                   直接申请 \n" +
                        "2、区工作室       所在城市区的数量 城市工作室满 10 人 \n" +
                        "3、社区工作室     所在区的社区数量 所在区工作室满 10 人 \n" +
                        "五、营养师加入原则 \n" +
                        "（一）邀约：工作室对所注册区域的认证营养师发起邀请，经过认证\n" +
                        "营养师同意后，算作加入该工作室。 \n" +
                        "（二）申请：认证营养师可根据所注册区域工作室代码，进行加入申\n" +
                        "请，待工作室通过后，算作加入该工作室。 \n" +
                        "（三）确认 \n" +
                        "双方同意可视作正式加入该工作室，服从该工作室管理办法。 \n" +
                        "六、工作室管理员 \n" +
                        "根据工作室管理规定，进行选拔。 \n" +
                        "七、分配原则 \n" +
                        "（一）个人客户业务（个人办理业务）： \n" +
                        "1、按平台标准分配：按照税前每个会员收入 100 元（北上广深 350\n" +
                        "元），会员购买商品利润 50%结算。平台代扣税点（为降低税点，工作室可\n" +
                        "以注册个体工商户） \n" +
                        "2、按工资分配：根据工作室所制定工资标准，接受工作室的考核，\n" +
                        "最终分配根据工作室考核结果分配。平台代扣税点（为降低税点，工作室\n" +
                        "可以注册个体工商户） \n" +
                        "（二）集团客户业务（单批次 10 人以上业务，单个业务不低于 150 元/人，有集\n" +
                        "团业务协议，对公账户支付，支付单位和协议单位一致） \n" +
                        "根据工作室相关制度进行参与人员分配 \n" +
                        "（三）政府业务（有政府相关合作文件） \n" +
                        "根据工作是相关制度进行参与人员分配 \n" +
                        "（四）实体店健康管理服务外包（单批次 10 人以上业务，单个业务不低于 150\n" +
                        "元/人，有实体店签约协议，对公账户支付，支付单位和协议单位一致） \n" +
                        "根据工作室相关制度进行参与人员分配 \n" +
                        "八、工作室退出机制 \n" +
                        "根据工作室管理规定，在双方友好协商的基础上，达成一致。 \n" +
                        "九、工作室发展规划示范（城市为例） \n" +
                        " \n" +
                        "十、工作室奖励办法（平台） \n" +
                        "（一）10 人（包含 10 人）以上工作室获得平台合作新闻媒体宣传奖\n" +
                        "励 \n" +
                        "（二）城市、区、社区工作室都达到 10 人，在平台上开始页的广告\n" +
                        "支持，为期一个月，价值 3 万； \n" +
                        "（三）城市、区工作室都达到 10 人，在平台首页首位广告支持，为\n" +
                        "期一个月，价值 1.5 万。 \n" +
                        "（四）季度当地城市第一名，且该季度客户增量达到 5000 名。合作\n" +
                        "媒体的广告支持，为期 3 个月，价值 5 万。 \n" +
                        "（五）连续两个季度当地城市第一名，且客户增量均超过 5000 名，\n" +
                        "城市外立面广告投放支持，为期 6 个月，价值 15 万； \n" +
                        "（六）得到地方政府合作业务的工作室，楼宇内部广告投放支持，为\n" +
                        "期一年，价值 3 万； \n" +
                        "（七）首次成立营养师工作室，并且工作室满足拥有 10 名当地营养\n" +
                        "师条件的城市，作为试点城市，获得地推营销支持，为期六个月价值\n" +
                        "约 6 万； \n" +
                        "（八）工作室会员人数在 1000 名以上，且每个月增长率超过 50%，\n" +
                        "工作室管理员当月可获得劳动奖励 500 元。 \n" +
                        "以上政策与营养师招募政策中《团队奖励办法》、《个人奖励办法》\n" +
                        "并存，奖励的工作室必须超过 10 名营养师（该地区），奖励政策自平\n" +
                        "台上线之日起，为期一年。 \n" +
                        "十一、公司股权激励 \n" +
                        "基于所有股东对目前项目前景持乐观态度，经公司董事会会议决\n" +
                        "定，开始实施股权激励计划。计划中将公司 4%的股份作为工作室管\n" +
                        "理员奖励，按照公司股票总数量两亿股计算，既 800 万股作为工作室\n" +
                        "管理员奖励。自平台上线之日起三年内，单个工作室达到会员人数超\n" +
                        "过两万名，工作室管理员将得到公司 10000 股的期权奖励，为上市前\n" +
                        "可获得相应分红，上市后公司按照当期股票价格进行回购，不得私自\n" +
                        "售卖或者转赠。 \n" +
                        "十二、江子杰会员商店体验店 \n" +
                        "为了进一步提高客户体验以及营养师的职业形象，公司在当地会\n" +
                        "员总人数超过 5000 时投放 300 平米的江子杰会员体验店（北上广深\n" +
                        "除外），该店作为客户体验场所，地区营养师工作交流场所。详情请\n" +
                        "参照实体体验店设计资料。 \n" +
                        "十三、子公司业务支撑 \n" +
                        "一个省，当每个城市均有超过 10 人的营养师工作室，公司在该\n" +
                        "省设立子公司，达到更好的支撑该地区工作室业务。 \n" +
                        "包括（但不限于）：集团业务洽谈、政府项目招标、实体店健康\n" +
                        "管理服务外包合作、工作室宣传。 \n" +
                        " \n" +
                        "联系人：李杰 \n" +
                        "联系电话：17801204909  18210889928 \n" +
                        "官方微信：微信公众号“江子杰会员商店”          \n" +
                        " \n" +
                        "                     \n" +
                        "英特帕克（北京）智能科技有限公司     \n" +
                        "二○一九年五月十日     \n" +
                        " \n" +
                        " \n" +
                        " \n" +
                        "主题词：健康 营养 社区 服务 \n" +
                        "英特帕克（北京）智能科技有限公司  二○一九年十月十日\n" +
                        "印发 \n" +
                        "共印发 10 份 ");
    }




}

