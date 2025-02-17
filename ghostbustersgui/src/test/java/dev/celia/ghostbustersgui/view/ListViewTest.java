package dev.celia.ghostbustersgui.view;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import static org.hamcrest.Matchers.is;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import dev.celia.ghostbustersgui.controller.UserController;
import dev.celia.ghostbustersgui.model.GhostClass;
import dev.celia.ghostbustersgui.model.GhostModel;

public class ListViewTest {
    @Mock
    private UserController mockUserController;

    private ListView listView;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        
        List<GhostModel> testGhosts = Arrays.asList(
                new GhostModel("Slimer", GhostClass.CLASS_I, "Bajo", "swdadawd", "2024-02-10"),
                new GhostModel("Phantom", GhostClass.CLASS_II, "Alto", "swdadawd", "2024-01-15"),
                new GhostModel("Specter", GhostClass.CLASS_I, "Medio", "swdadawd", "2024-02-20")
        );

        when(mockUserController.getCapturedGhosts()).thenReturn(testGhosts);
        
        listView = new ListView(mockUserController);
    }

    @Test
    @DisplayName("Test para la vista de filtrar por clase")
    void testFilterByClass() {
        listView.classFilter.setSelectedItem(GhostClass.CLASS_I);
        listView.filterByClass();

        DefaultTableModel model = (DefaultTableModel) listView.table.getModel();

        assertEquals(2, model.getRowCount());
        assertEquals("Slimer", model.getValueAt(0, 1));
        assertEquals("Specter", model.getValueAt(1, 1));
    }

    @Test
    @DisplayName("Test para la vista de filtrar por mes")
    void testFilterByMonth() {
        listView.monthFilter.setText("2");
        listView.filterByMonth();

        DefaultTableModel model = (DefaultTableModel) listView.table.getModel();

        assertEquals(2, model.getRowCount());
        assertEquals("Slimer", model.getValueAt(0, 1));
        assertEquals("Specter", model.getValueAt(1, 1));
    }

    @Test
    @DisplayName("Test para liberar un fantasma de forma manual")
    void testReleaseGhost() {
        listView.table.setRowSelectionInterval(0, 0);
        
        when(mockUserController.releaseGhost(1)).thenReturn(true);
        
        listView.releaseGhost();

        ArgumentCaptor<Integer> idCaptor = ArgumentCaptor.forClass(Integer.class);
        verify(mockUserController).releaseGhost(idCaptor.capture());
        assertThat(idCaptor.getValue(), is(1));

        verify(mockUserController, times(2)).getCapturedGhosts();
    }
}