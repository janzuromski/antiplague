import javax.swing.*;
import javax.swing.event.ListDataListener;
import java.awt.*;
import java.util.Collections;
import java.util.List;

public class RankingList extends JList {

    public RankingList() {
        setModel(new RankingModel());
        setCellRenderer(new RankingCell());
    }

}

class RankingCell extends JLabel implements ListCellRenderer<Player> {

    @Override
    public Component getListCellRendererComponent(JList<? extends Player> list, Player value, int index,
                                                  boolean isSelected, boolean cellHasFocus) {
        setText((index + 1) + ". " + value.getNAME() + ", " + value.getDIFFICULTY() + ", Punkty: " + value.getPOINTS());
        return this;
    }
}

class RankingModel implements ListModel<Player> {
    List<Player> players;

    public RankingModel() {
        players = Ranking.readRanking();
        Collections.sort(players);
        Collections.reverse(players);
    }

    @Override
    public int getSize() {
        return players.size();
    }

    @Override
    public Player getElementAt(int index) {
        return players.get(index);
    }

    @Override
    public void addListDataListener(ListDataListener l) {

    }

    @Override
    public void removeListDataListener(ListDataListener l) {

    }
}

