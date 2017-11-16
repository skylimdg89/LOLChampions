package edu.mnstate.mg0483fp.lollogin;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ChampionAdapter extends RecyclerView.Adapter<ChampionAdapter.CustomViewHolder> {

    Context context;
    ArrayList<Champion> champArrayList;
    int index=0;

    public ChampionAdapter(Context context, ArrayList<Champion> champArrayList) {
        this.context = context;
        this.champArrayList = champArrayList;
    }


    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.champ_row,parent, false );
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        Toast.makeText(context, "onBindViewHolder: " + position, Toast.LENGTH_LONG).show();
        Champion champion = champArrayList.get(position);
        String getCap = champion.champName.substring(0,1).toUpperCase() + champion.champName.substring(1);
        holder.imageButton1.setImageResource(champion.imageResId);
        holder.champname_text.setText(getCap);
        holder.lines_text.setText(nickname[position]);
        holder.wherefrom_text.setText(wherefrom[position]);
    }

    @Override
    public int getItemCount() {
        return champArrayList.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        ImageButton imageButton1;

        TextView champname_text;
        TextView lines_text;
        TextView wherefrom_text;

        public CustomViewHolder(View view) {
            super(view);
            imageButton1 =(ImageButton) view.findViewById(R.id.imageButton1);
            champname_text = (TextView) view.findViewById(R.id.champname_text);
            lines_text = (TextView) view.findViewById(R.id.lines_text);
            wherefrom_text = (TextView) view.findViewById(R.id.wherefrom_text);

            view.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    //champArrayList.remove(getAdapterPosition());
                    Intent intent = new Intent(context, InfoActivity.class);
                    intent.putExtra("image", getAdapterPosition());
                    Log.i("MainActivity", "################position = " + getAdapterPosition() + "############");
                    index = getAdapterPosition();
                    context.startActivity(intent);
                    notifyDataSetChanged();
                }
            });


        }
    }


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
            "independent", "Freljord", "", "Shurima", "Independent", "Zaun", " Independent", "Freljord",
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
}

