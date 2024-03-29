(ns agatha.ui.views
  (:require [reagent.core :as r]
            [re-frame.core :refer [subscribe]]
            [agatha.net :refer [connect hang-up-call handle-key handle-send-button]]))

(defn app-root []
  [:div.container
   [:div.infobox
    [:p "Click a username in the user list to ask them to enter a one-on-one video chat with you."]
    [:p "Enter a username:"
     [:input {:id "name" :type "text" :maxLength "12" :required true :autoComplete "username" :inputMode "verbatim" :placeholder "Username"}]
     [:input {:type "button" :name "login" :value "Log in" :onClick connect}]]]
   [:ul.userlistbox]
   [:div.chatbox]
   [:div.camerabox
    [:video {:id "received_video" :autoPlay true}]
    [:video {:id "local_video" :autoPlay true :muted true}]]
   [:button {:id "hangup_button" :onClick hang-up-call :role "button" :disabled true} "Hang Up"]
   [:div.empty-container]
   [:div.chat-controls "Chat:" [:br]
    [:input {:id "text" :type "text" :name "text" :size "100" :maxLength "256" :placeholder "Say something meaningful..." :autoComplete "off" :onKeyUp handle-key :disabled true}]
    [:input {:type "button" :id "send" :name "send" :value "Send" :onClick handle-send-button :disabled true}]]])