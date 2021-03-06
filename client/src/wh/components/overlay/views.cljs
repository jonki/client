(ns wh.components.overlay.views
  (:require
    [wh.components.icons :refer [icon]]))

(defn popup-wrapper
  [{:keys [id on-close on-ok button-label button-class codi? class]
    :or {codi? true
         class "generic-popup"}} & body]
  [:div.is-full-panel-overlay
   [:div.popup.has-text-centered
    {:class (str class "__popup " class "__popup--" (name id))
     :on-click #(.stopPropagation %)}
    (conj (into
           [:div
            (when codi? [:div.popup__codi
                         {:class (str class "__popup__codi")}
                         [icon "codi"]])
            (when on-close [:div.popup__close
                            {:on-click on-close
                             :class (str class "__popup__close")}
                            [icon "close"]])]
           body)
          (when on-ok
            [:button.button.button--small
             {:class button-class
              :on-click on-ok}
             (or button-label "OK")]))]])
