package com.example.application.views.myview;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;

@PageTitle("My View")
@Route("")
@Menu(order = 0, icon = "line-awesome/svg/pencil-ruler-solid.svg")
@AnonymousAllowed
public class MyViewView extends Composite<VerticalLayout> {

    public MyViewView() {
        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        Grid<String> grid = new Grid<>();
        grid.addColumn( s -> s).setHeader("foo");
        grid.addColumn( s -> s).setHeader("bar");
        Grid<String> emptyStateGrid = new Grid<>();
        emptyStateGrid.addColumn(s -> s).setHeader("quux");
        emptyStateGrid.addColumn(s -> s).setHeader("bizzle");
        emptyStateGrid.setItems("foo", "bar", "baz");
        grid.setEmptyStateComponent(emptyStateGrid);
        getContent().add(grid);
    }
}
