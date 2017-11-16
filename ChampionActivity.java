package edu.mnstate.mg0483fp.lollogin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class ChampionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_champion);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<Champion> champ_array = new ArrayList<>();

        try {
            for (int i = 0; i < drawable_array.length; i++) {
                drawable_array[i] = this.getResources().getIdentifier(image_array[i], "drawable", this.getPackageName());
                Champion pic1 = new Champion(image_array[i], drawable_array[i]);
                champ_array.add(pic1);

            }
        }catch(Exception e){
        }

        ChampionAdapter champAdapter = new ChampionAdapter(getApplicationContext(), champ_array);
        recyclerView.setAdapter(champAdapter);
    }

    String[] image_array = {"aatrox", "ahri", "akali", "alistar", "amumu", "anivia", "annie",
            "ashe", "aurelionsol", "azir", "bard", "blitzcrank", "brand", "braum",
            "caitlyn", "camille", "cassiopeia", "chogath", "corki", "darius", "diana",
            "mundo", "draven", "ekko", "elise", "evelynn", "ezreal", "fiddlesticks",
            "fiora", "fizz", "galio", "gangplank", "garen", "gnar", "gragas",
            "graves", "hecarim", "heimerdinger", "illaoi", "irelia", "ivern", "janna",
            "j4", "jax", "jayce", "jhin", "jinx", "kalista", "karma",
            "karthus", "kassadin", "katarina", "kayle", "kennen", "khazix", "kindred",
            "kled", "kogmaw", "leblanc", "leesin", "leona", "lissandra", "lucian",
            "lulu", "lux", "malphite", "malzahar", "maokai", "masteryi", "missfortune",
            "mordekaiser", "morgana", "nami", "nasus", "nautilus", "nidalee", "nocturne",
            "nunu", "olaf", "orianna", "pantheon", "poppy", "quinn", "rammus",
            "reksai", "renekton", "rengar", "riven", "rumble", "ryze", "sejuani",
            "shaco", "shen", "shyvana", "singed", "sion", "sivir", "skarner",
            "sona", "soraka", "swain", "syndra", "tahmkench", "taliyah", "talon",
            "taric", "teemo", "thresh", "tristana", "trundle", "tryndamere", "twistedfate",
            "twitch", "udyr", "urgot", "varus", "vayne", "veigar", "velkoz",
            "vi", "viktor", "vladimir", "volibear", "warwick", "wukong", "xerath",
            "xinzhao", "yasuo", "yorick", "zac", "zed", "ziggs", "zilean",
            "zyra"};

    Integer[] drawable_array = {R.drawable.aatrox, R.drawable.ahri, R.drawable.akali, R.drawable.alistar,
            R.drawable.amumu, R.drawable.anivia, R.drawable.annie, R.drawable.ashe,
            R.drawable.aurelionsol, R.drawable.azir, R.drawable.bard, R.drawable.blitzcrank,
            R.drawable.brand, R.drawable.braum, R.drawable.caitlyn, R.drawable.camille,
            R.drawable.cassiopeia, R.drawable.chogath, R.drawable.corki, R.drawable.darius,
            R.drawable.diana, R.drawable.mundo, R.drawable.draven, R.drawable.ekko, R.drawable.elise,
            R.drawable.evelynn, R.drawable.ezreal, R.drawable.fiddlesticks, R.drawable.fiora,
            R.drawable.fizz, R.drawable.galio, R.drawable.gangplank, R.drawable.garen, R.drawable.gnar,
            R.drawable.gragas, R.drawable.graves, R.drawable.hecarim, R.drawable.heimerdinger,
            R.drawable.illaoi, R.drawable.irelia, R.drawable.ivern, R.drawable.janna,
            R.drawable.j4, R.drawable.jax, R.drawable.jayce, R.drawable.jhin, R.drawable.jinx,
            R.drawable.kalista, R.drawable.karma, R.drawable.karthus, R.drawable.kassadin,
            R.drawable.katarina, R.drawable.kayle, R.drawable.kennen, R.drawable.khazix,
            R.drawable.kindred, R.drawable.kled, R.drawable.kogmaw, R.drawable.leblanc, R.drawable.leesin,
            R.drawable.leona, R.drawable.lissandra, R.drawable.lucian, R.drawable.lulu,
            R.drawable.lux, R.drawable.malphite, R.drawable.malzahar, R.drawable.maokai,
            R.drawable.masteryi, R.drawable.missfortune, R.drawable.mordekaiser, R.drawable.morgana,
            R.drawable.nami, R.drawable.nasus, R.drawable.nautilus, R.drawable.nidalee, R.drawable.nocturne,
            R.drawable.nunu, R.drawable.olaf, R.drawable.orianna, R.drawable.pantheon, R.drawable.poppy,
            R.drawable.quinn, R.drawable.rammus, R.drawable.reksai, R.drawable.renekton, R.drawable.rengar,
            R.drawable.riven, R.drawable.rumble, R.drawable.ryze, R.drawable.sejuani, R.drawable.shaco,
            R.drawable.shen, R.drawable.shyvana, R.drawable.singed, R.drawable.sion, R.drawable.sivir,
            R.drawable.skarner, R.drawable.sona, R.drawable.soraka, R.drawable.swain, R.drawable.syndra,
            R.drawable.tahmkench, R.drawable.taliyah, R.drawable.talon, R.drawable.taric, R.drawable.teemo,
            R.drawable.thresh, R.drawable.tristana, R.drawable.trundle, R.drawable.tryndamere,
            R.drawable.twistedfate, R.drawable.twitch, R.drawable.udyr, R.drawable.urgot, R.drawable.varus,
            R.drawable.vayne, R.drawable.veigar, R.drawable.velkoz, R.drawable.vi, R.drawable.viktor,
            R.drawable.vladimir, R.drawable.volibear, R.drawable.warwick, R.drawable.wukong, R.drawable.xerath,
            R.drawable.xinzhao, R.drawable.yasuo, R.drawable.yorick, R.drawable.zac, R.drawable.zed,
            R.drawable.ziggs, R.drawable.zilean, R.drawable.zyra};
}

