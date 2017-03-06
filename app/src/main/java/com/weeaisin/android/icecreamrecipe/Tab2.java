package com.weeaisin.android.icecreamrecipe;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by AiLeng on 05-Mar-17.
 */

public class Tab2 extends Fragment {

    private TextView txt2;
    //Overriden method onCreateView
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //Returning the layout file after inflating
        //Change R.layout.tab1 in you classes
        View view = inflater.inflate(R.layout.tab2, container, false);

        TextView txt1 = (TextView)view.findViewById(R.id.textView2);
        txt1.setText("1. In a saucepan over medium-low heat, combine the half and half, brown sugar, white sugar, and salt. Stir until sugar dissolves, about 5 minutes.\n" + "\n" +
                "2. Take saucepan off heat. Place eggs in a medium bowl. While whisking, gradually (to not curdle the eggs) add about half the sugar mixture to the eggs.\n" + "\n" +
                "3. Pour egg mixture into saucepan with the half and half that remained in the saucepan.\n" + "\n" +
                "4. Stir in cream.\n" + "\n" +
                "5. Cook over medium heat, stirring frequently, until mixture thickens and coats the back of a spoon. About 5 to 10 minutes.\n" + "\n" +
                "6. Take saucepan off heat and stir in vanilla extract. Pour mixture through a fine-meshed sieve into a bowl and let cool to room temperature.\n" + "\n" +
                "7. Once cooled, stir in mashed banana and pour into an ice cream maker. Use manufacturer's directions to freeze. Add Nilla wafers about 5 minutes before end of freezing time.\n" + "\n" +
                "8. If ice cream is too soft for your liking at this point, place in freezer for about 1 hour.");

        return view;

    }
}
