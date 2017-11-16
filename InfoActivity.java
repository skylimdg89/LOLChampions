package edu.mnstate.mg0483fp.lollogin;


import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;


public class InfoActivity extends  YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        champ_name_text = (TextView)findViewById(R.id.champ_name_text);

        data = getIntent().getExtras().getInt("image");
        champ_name_text.setText(image_array[data]);

        YouTubePlayerView youTubePlayerView = (YouTubePlayerView)findViewById(R.id.youtube_player);
        youTubePlayerView.initialize(DEVELOPER_KEY, this);


    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean wasRestored) {
        if(youTubePlayer == null) return;
        //Start buffering
        if(!wasRestored){
            youTubePlayer.cueVideo(VIDEO_ID[data]);
        }

    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        Toast.makeText(this,"Failed to initialize.", Toast.LENGTH_LONG).show();
    }
    public static final String DEVELOPER_KEY = "AIzaSyArUXgybrY4qVEuyDbELGaSSEcbE5jcz8o";
    private static final String[] VIDEO_ID = {"0gvBGmwhOLU", "hlalkAUkwqE", "w8UjQ_hYfh4", "dnCkD5w5D3k","qh3yle16m-U",
            "8Syose1O568", "8bhu_eN3Uso", "mSbMQ5xDnEg", "HM520graePQ","zqH4AA-KEgQ", "-tNDoXIYptk", "WtmMC23DdT0",
            "vvuAw6KNn2E", "ajUghBnxZQA","KFNFY6-gaDA", "YaNANTQH0zc", "neQNvEyuhPU", "GJ8QI_7puvU", "ABYix52iBj0",
            "0M15wr-5O18", "H7WSLWcACiw", "E88Vv9nMpI4", "h5zyGj4Z0Sg", "cpq3liaA1U4", "mOz4uDKs2dM", "hHuGtuWQoC4",
            "0dGYt0Ibw94", "uc_-ms5ADhk", "YRyGvsGbHnM","ATbmKP9RoXI", "sOQGg1-RzWw", "fcjnSmRyu5o", "Q7oyW6LjxrA",
            "4Qu3rhWGq0s", "t4zwS6brHrw","BWzyB4xe7Y8", "6DVGJm-u6To", "PY2q3aA1NYo", "UFkCDRlb9FA", "MFcsOX9xcIo",
            "Y-gsY5oAsL0", "tlHpXy_VNpE", "RgOdf3x24qA", "B18qApcVCRg", "p2YuyBZ_zMU", "QvNw0A-D0T0", "KN3OYwP8nHE",
            "XCR-tMpKtt8", "lWIj3IRz8DI", "zSKw3m7JGvg", "pBoPH0qtMxc", "soCg5RbgYIA", "kn-Y6jawdHM", "ZmYVifYPFsY",
            "jKLK9zFiVII", "h0Pwn7G-eLE", "Pz145kVa-4w", "_uZ1ltl-qPM", "we5LawDUcCM", "e6SleHuJjLo", "oViu5Pv_wwY",
            "xsCp5lBceTA", "2rIiuLXXGEg", "R1Gs1D2rUIM", "pJB6JWDESWU", "P4MJpOZTL_4", "PC5ScnEH-Rc", "Gw8f-VqAcQo",
            "RJo0YzTyvXw", "vZh_hN-62YA", "ZFdKO5WtJiw", "wE1r_3x-_98", "wd_Sz59QTVk", "pnbtna-Qvns", "IyOeyjwZT28",
            "KZjRgm4mF_U", "owrwt97AH54", "oySqXCJE1YE", "YuC3ZUY88d8", "EUpTRoSQEX4", "h2yjpxzTNvs", "Oe-NJKTgz7c",
            "O9eVLrcih9s", "aeU2b9s-ZVw", "bmurGIqiPgg", "IDXEHgsLfeM", "gbHGFazlpCA", "V_ERvayBr3M", "Dghwqj_Qddc",
            "qNk6uNCLuDo", "bOWoAktkGQg", "Q9m48jiVWL4", "JIIE0LCvGpo", "Z66n3UYfPE4", "ZOpT__qwjdQ", "4mWWFC9SRfA",
            "6NkXkpHnf30", "vLxbEDJykcI", "JP0A3wLfFBg", "KJ6f1nsoUTs", "i19hj3LVP7A", "YqI7N2R8tx4", "VYlOFKLmiHA",
            "3-XQ0Jb2MRs", "eKdX7aB3TRk", "Y91qo99osLI", "Qj48qHM1MXE", "Sv95nBi7ulQ", "633CHC6TTYY", "cg0-Kw9Iozw",
            "VmXEnxyVcs0", "B8Ai_Aw-5fc", "cFtH_wFJBLs", "dK4PwnV59ik", "1bQtJZW1x08", "twiHstUjNkY", "gZDJqpFspmg",
            "R_x72Z9Dzog", "IWA2C8tUG-g", "vp3ZrRJz-ZY", "cHD781_Je7Q", "eiUgrEWRx6M", "pVrWNNnhSww", "Rro20bR4jnQ",
            "k1zAhC5aeQs", "2v5MmuMJ2qU", "9l1lj_9Xg-E", "fkM20LgOdKQ", "RUVveKdiU_U", "lr8kHe4vqZQ", "2DFtlNGzMIA",
            "kNabvLyUXzI","j5_9kel07E8","v9DLY0Qrcm4"};

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

    String[] nickname = {"the Darkin Blade", "the Nine-Tailed Fox", "the Fist of Shadow", "the Minotaur",
            "the Sad Mummy", "the Cryophoenix", "the Dark Child", "the Frost Archer", "The Star Forger",
            "the Emperor of the Sands", "the Wandering Caretaker", "the Great Steam Golem", "the Burning Vengeance",
            "the Heart of the Freljord", "the Sheriff of Piltover", "the Steel Shadow", "the Serpents Embrace",
            "the Terror of the Void", "the Daring Bombardier", "the Hand of Noxus", "Scorn of the Moon",
            "the Madman of Zaun", "the Glorious Executioner", "the Boy Who Shattered Time", "the Spider Queen",
            "the Widowmaker", "the Prodigal Explorer", "the Harbinger of Doom", "the Grand Duelist",
            "the Tidal Trickster", "the Sentinels Sorrow", "the Saltwater Scourge", "The Might of Demacia",
            "the Missing Link", "the Rabble Rouser", "the Shadow of War", "the Revered Inventor",
            "the Graken Priestess", "the Will of the Blades", "the Green Father", "the Storms Fury",
            "the Exemplar of Demacia", "Grandmaster at Arms", "the Defender of Tomorrow", "the Virtuoso",
            "the Loose Cannon", "the Spear of Vengeance", "the Enlightened One", "the Deathsinger",
            "the Void Walker", "the Sinister Blade", "The Judicator", "the Heart of the Tempest", "the Voidreaver",
            "The Eternal Hunters", "the Cantankerous Cavalier", "the Mouth of the Abyss", "the Deceiver",
            "the Blind Monk", "the Radiant Dawn", "the Ice Witch", "the Purifier", "the Fae Sorceress",
            "the Lady of Luminosity", "Shard of the Monolith", "the Prophet of the Void", "the Twisted Treant",
            "the Wuju Bladesman", "the Bounty Hunter", "the Oron Revenant", "Fallen Angel", "the Tidecaller",
            "the Curator of the Sands", "the Titan of the Depths", "the Bestial Huntress", "the Eternal Nightmare",
            "the Yeti Rider", "the Berserker", "the Lady of Clockwork", "the Artisan of War", "Keeper of the Hammer",
            "Demacias Wings", "the Armordilo", "the Void Burrower", "the Butcher of the Sands", "the Pridestalker",
            "the Exile", "the Mechanized Menace", "the Rune Mage", "the Winter's Wrath", "the Demon Jester",
            "the Eye of Twilight", "the Half Dragon", "the Mad Chemist", "The Undead Juggernaut", "the Battle Mistress",
            "the Crystal Vanguard", "Maven of the Strings","the Startchild", "the master Tactician", "the Dark Sovereign",
            "the River King", "the Stoneweaver", "the Blades Shadow", "the Sheild of Valoran", "the Swift Scout",
            "the Chain Warden", "the Yordle Gunner", "the Troll King", "the Barbarian King", "the Card Master",
            "the Plague Rat", "the Spirit Walker", "the Headsmans Pride", "the Arrow of Retribution", "the Night Hunter",
            "the Tiny Master of Evil", "the Eye of the Void", "the Pitover Enforcer", "the Machine Herald",
            "the Crimson Reaper", "the THunders Roar", "the Blood Hunter", "the Monkey King", "the Magus Ascendant",
            "the Senschal of Demacia", "the Unforgiven", "Shepherd of Souls", "the Secret Weapon", "the Master of Shadows",
            "the Hexplosives Expert", "the Chronokeeper", "Rise of the Thorns"


    };

    String[] wherefrom = {"Independent", "Ionia", "Ionia", "Independent", "Badle City", "Freljord",
            "independent", "Freljord", "", "Shurima", "Independent", "Zaun"," Independent", "Freljord",
            "Piltover", "", "Shurima / Noxus", "Void", "Bandle City", "Noxus", "Mt. Targon", "Zaun",
            "Noxus", "Zaun", "Shadow Isles", "Shadow Isles", "Piltover", "Independent", "Demacia", "Bilgewater",
            "Demacia", "Bilgewater", "Demacia", "Independent", "Freljord", "Shadow Isles", "Bandle City",
            "Bilgewater", "Ionia", "Independent", "Independent", "Demacia", "Ionia", "Piltover", "Ionia",
            "Zaun", "Shadow Isles", "Ionia", "Shadow Isles", "Void", "Noxus", "Demacia", "Ionia / Bandle City",
            "Void", "Independent", "Noxus", "Void", "Noxus", "Ionia", "Mt. Targon", "Freljord", "Demacia",
            "Bandle City", "Demacia", "Independent", "Void", "Independent", "Ionia", "Bilgewater", "Shadow Isels",
            "Noxus", "Independent", "Shurima", "Bilgewater", "Independent", "Independent", "Freljord", "Freljord",
            "Piltover", "Mt. Targon", "Bandle City / Demacia", "Demacia", "Shurima", "Void", "Shurima", "Independent",
            "Noxus", "Bandle City", "Independent", "Freljord", "Independent", "Ionia", "Demacia", "Zaun", "Noxus",
            "Shurima", "Independent", "Demacia / Ionia", "Ionia", "Noxus", "Ionia", "Independent", "Shurima",
            "Noxus", "", "Bandle City", "Shadow Isles", "Bandle City", "Freljord", "Freljord", "Bilgewater", "Zaun",
            "Freljord / Ionia", "Noxus / Zaun", "Ionia", "Demacia", "Bandle City", "Void", "Pitover", "Zaun", "Noxus",
            "Freljord", "Zaun", "Ionia", "Shurima", "Demacia", "Ionia", "Shadow Isles", "Zaun", "Ionia", "Bandle City",
            "Piltover", "Independent"




    };



    int data;

    TextView champ_name_text;


}
