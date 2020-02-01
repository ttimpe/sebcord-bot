package coffee.michel.sebcord.bot.ui;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.HasElement;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.RouterLayout;
import com.vaadin.flow.server.InitialPageSettings;
import com.vaadin.flow.server.PageConfigurator;
import com.vaadin.flow.server.VaadinSession;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;

import coffee.michel.sebcord.bot.ui.first.ConfigurationMain;
import coffee.michel.sebcord.bot.ui.second.Cat2Main;

@Theme(value = Lumo.class, variant = Lumo.DARK)
public class MainContainer extends VerticalLayout implements PageConfigurator, RouterLayout, BeforeEnterObserver {
	private static final long serialVersionUID = 5473853593L;

	public MainContainer() {
		super();
		this.initUI();
	}

	@Override
	public void showRouterLayoutContent(final HasElement content) {
		this.getElement().appendChild(content.getElement());
	}

	@Override
	public void configurePage(final InitialPageSettings settings) {
		settings.addLink("shortcut icon", "frontend/images/favicon.ico");
		settings.addFavIcon("icon", "frontend/images/favicon256.png", "256x256");
	}

	/**
	 * Event handler delegate method for the {@link Button} {@link #btnNavCat1}.
	 *
	 * @see ComponentEventListener#onComponentEvent(ComponentEvent)
	 * @eventHandlerDelegate Do NOT delete, used by UI designer!
	 */
	private void btnNavCat1_onClick(final ClickEvent<Button> event) {
		UI.getCurrent().navigate(ConfigurationMain.class);
	}

	/**
	 * Event handler delegate method for the {@link Button} {@link #btnNavCat2}.
	 *
	 * @see ComponentEventListener#onComponentEvent(ComponentEvent)
	 * @eventHandlerDelegate Do NOT delete, used by UI designer!
	 */
	private void btnNavCat2_onClick(final ClickEvent<Button> event) {
		UI.getCurrent().navigate(Cat2Main.class);
	}

	/**
	 * Event handler delegate method for the {@link Button} {@link #btnHome}.
	 *
	 * @see ComponentEventListener#onComponentEvent(ComponentEvent)
	 * @eventHandlerDelegate Do NOT delete, used by UI designer!
	 */
	private void btnHome_onClick(final ClickEvent<Button> event) {
		UI.getCurrent().navigate(MainView.class);
	}

	/*
	 * WARNING: Do NOT edit!<br>The content of this method is always regenerated by
	 * the UI designer.
	 */
	// <generated-code name="initUI">
	private void initUI() {
		this.navContainerMain = new HorizontalLayout();
		this.btnHome = new Button();
		this.btnNavCat1 = new Button();
		this.btnNavCat2 = new Button();

		this.setSpacing(false);
		this.setPadding(false);
		this.setDefaultHorizontalComponentAlignment(FlexComponent.Alignment.STRETCH);
		this.navContainerMain.setClassName("my-header");
		this.navContainerMain.setSpacing(false);
		this.navContainerMain.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.STRETCH);
		this.btnHome.setClassName("my-navbutton");
		this.btnHome.setIcon(VaadinIcon.HOME.create());
		this.btnNavCat1.setClassName("my-navbutton");
		this.btnNavCat1.setText("Einstellungen");
		this.btnNavCat2.setClassName("my-navbutton");
		this.btnNavCat2.setText("media");

		this.btnHome.setSizeUndefined();
		this.btnNavCat1.setSizeUndefined();
		this.btnNavCat2.setSizeUndefined();
		this.navContainerMain.add(this.btnHome, this.btnNavCat1, this.btnNavCat2);
		this.navContainerMain.setSizeUndefined();
		this.add(this.navContainerMain);
		this.setSizeFull();

		this.btnHome.addClickListener(this::btnHome_onClick);
		this.btnNavCat1.addClickListener(this::btnNavCat1_onClick);
		this.btnNavCat2.addClickListener(this::btnNavCat2_onClick);
	} // </generated-code>

	// <generated-code name="variables">
	private Button           btnHome, btnNavCat1, btnNavCat2;
	private HorizontalLayout navContainerMain;
	// </generated-code>

	@Override
	public void beforeEnter(BeforeEnterEvent event) {
		VaadinSession currentSession = VaadinSession.getCurrent();
		Object attribute = currentSession.getAttribute("discord.token");
		if (attribute == null) {
			event.forwardTo(LoginView.class);
			return;
		}
		String discordToken = String.valueOf(attribute);
		if (discordToken.isEmpty()) {
			event.forwardTo(LoginView.class);
			return;
		}

		// TODO
	}

}
